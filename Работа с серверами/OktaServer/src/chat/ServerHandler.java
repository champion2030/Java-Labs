package chat;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

public class ServerHandler extends Thread{

    private final ServerSocket server;

    ServerHandler(ServerSocket server){
        this.server = server;
    }

    @Override
    public void run(){
        while (true){
            try{
                Socket client = server.accept();
                ClientHandler handler = new ClientHandler(client);
                ServerLoader.handlers.put(client,handler);
                Thread.sleep(10);
            }catch (SocketException ex){
                return;
            }
            catch (IOException | InterruptedException ex){
                ex.printStackTrace();
            }
        }
    }

}
