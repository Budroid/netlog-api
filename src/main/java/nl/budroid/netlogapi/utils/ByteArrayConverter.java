package nl.budroid.netlogapi.utils;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class ByteArrayConverter {

    public static short toShort(byte[] bytes) {
        return ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN).getShort();
    }

}
