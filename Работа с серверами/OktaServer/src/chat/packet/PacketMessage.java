package chat.packet;

import chat.ServerLoader;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class PacketMessage extends OPacket{

    private String sender, message;

    public PacketMessage() {};

    public PacketMessage(String sender, String message){
        this.sender = sender;
        this.message = message;
    }

    @Override
    public short getId() {
        return 2;
    }

    @Override
    public void write(DataOutputStream dos) throws IOException {
        dos.writeUTF(sender);
        dos.writeUTF(message);
    }

    @Override
    public void read(DataInputStream dis) throws IOException {
        message = dis.readUTF();
    }

    @Override
    public void handle() {
        sender = ServerLoader.getHandler(getSocket()).getNickname();
        ServerLoader.handlers.keySet().forEach(s -> {
            try {
                ServerLoader.sentPacket(s, this);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        System.out.println(String.format("[%s] %s", sender, message));
    }
}
