package chat;

import chat.packet.OPacket;
import chat.packet.PacketAuthorize;
import chat.packet.PacketManager;
import chat.packet.PacketMessage;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class ClientLoader {

    private static Socket socket;
    private static boolean sendNickName = false;

    public static void main(String[] args) throws IOException, InterruptedException {
        connect();
        handle();
        end();
    }

    private static void connect() throws IOException {
        socket = new Socket("localhost", 8888);
    }

    private static void readChat() throws InterruptedException, IOException {
        Scanner scan = new Scanner(System.in);
        while (!socket.isClosed()){
            if(scan.hasNextLine()){
                String line = scan.nextLine();
                if (line.equals("/end")){
                    end();
                }
                if(!sendNickName){
                    sendNickName = true;
                    sendPacket(new PacketAuthorize(line));
                    continue;
                }
                sendPacket(new PacketMessage(null, line));
            }
            else {
                Thread.sleep(10);
            }
        }
    }

    private static void handle() throws IOException, InterruptedException {
        Thread handler = new Thread(){
            @Override
            public void run(){
                while (true){
                    try {
                        DataInputStream dis = new DataInputStream(socket.getInputStream());
                        if(dis.available() <= 0){
                            Thread.sleep(10);
                            continue;
                        }
                        short id = dis.readShort();
                        OPacket packet = PacketManager.getPacket(id);
                        packet.read(dis);
                        packet.handle();
                    } catch (IOException | InterruptedException | IllegalAccessException | InstantiationException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        handler.start();
        readChat();
    }

    public static void sendPacket(OPacket packet) throws IOException {
        DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
        dos.writeShort(packet.getId());
        packet.write(dos);
        dos.flush();
    }

    private static void end() throws IOException {
        socket.close();
        System.exit(0);
    }
}
