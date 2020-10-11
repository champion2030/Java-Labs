package chat;

import chat.packet.OPacket;
import chat.packet.PacketManager;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientHandler extends Thread{

    private final Socket client;
    private String nickname = "None";

    public ClientHandler(Socket client){
        this.client = client;
        start();
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    @Override
    public void run(){
        while (true){
            try {
                if(!readData()){
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            } catch (IOException | InstantiationException | IllegalAccessException | InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private boolean readData() throws IOException, InstantiationException, IllegalAccessException, InterruptedException {
        DataInputStream dis = new DataInputStream(client.getInputStream());
        if(dis.available() <= 0 ) {
            return false;
        }
        short id = dis.readShort();
        OPacket packet = PacketManager.getPacket(id);
        packet.setSocket(client);
        packet.read(dis);
        packet.handle();
        return true;
    }

    public void invalidate(){
        ServerLoader.invalidate(client);
    }
}
