package chat.packet;

import java.io.DataInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class PacketManager {

    private final static Map<Short, Class<? extends OPacket>> packets = new HashMap<>();

    static {
        packets.put((short) 1, PacketAuthorize.class);
        packets.put((short) 2, PacketMessage.class);
    }

    public static OPacket getPacket(short id) throws IllegalAccessException, InstantiationException {
        return packets.get(id).newInstance();
    }

    public static void read(short id, DataInputStream dis) throws IllegalAccessException, InstantiationException, IOException {
        OPacket packet = packets.get(id).newInstance();
        packet.read(dis);
    }

}
