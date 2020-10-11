package chat.packet;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class PacketAuthorize extends OPacket{

    private String nickname;

    public PacketAuthorize(String nickname){
        this.nickname = nickname;
    }

    public PacketAuthorize(){

    }

    @Override
    public short getId() {
        return 1;
    }

    @Override
    public void write(DataOutputStream dos) throws IOException {
        dos.writeUTF(nickname);
    }

    @Override
    public void read(DataInputStream dis) {

    }

    @Override
    public void handle() {

    }
}
