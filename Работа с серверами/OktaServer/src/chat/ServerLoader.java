package chat;

import chat.packet.OPacket;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ServerLoader {

    private static ServerSocket server;
    private static ServerHandler handler;
    public static Map<Socket, ClientHandler> handlers = new HashMap<>();
    public static void main(String[] args) throws IOException, InterruptedException {
        start();
        handle();
        end();
    }

    private static void start() throws IOException {
        server = new ServerSocket(8888);
    }

    private static void handle() throws InterruptedException, IOException {
        handler = new ServerHandler(server);
        handler.start();
        readChat();
    }

    private static void readChat() throws InterruptedException, IOException {
        Scanner scan = new Scanner(System.in);
        while (!server.isClosed()){
            if(scan.hasNextLine()){
                String line = scan.nextLine();
                if(line.equals("/end")){
                    end();
                }
                else {
                    System.out.println("Unknown command");
                }
            }
            else {
                Thread.sleep(10);
            }
        }
    }

    public static void sentPacket(Socket receiver, OPacket packet) throws IOException {
        DataOutputStream dos = new DataOutputStream(receiver.getOutputStream());
        dos.writeShort(packet.getId());
        packet.write(dos);
        dos.flush();
    }

    public static ServerHandler getServerHandler(){
        return handler;
    }

    public static void end() throws IOException {
        server.close();
    }

    public static ClientHandler getHandler(Socket socket){
        return handlers.get(socket);
    }

    public static void invalidate(Socket socket){
        handlers.remove(socket);
    }
}
