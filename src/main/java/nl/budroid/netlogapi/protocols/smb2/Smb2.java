package nl.budroid.netlogapi.protocols.smb2;

import lombok.Getter;
import nl.budroid.netlogapi.utils.ByteArrayConverter;

import java.util.Arrays;

@Getter
public class Smb2 {

    private Smb2Header smb2Header;

    public Smb2(byte[] smb2Packet) {
        // Check the length of the header first
        short length = ByteArrayConverter.toShort(Arrays.copyOfRange(smb2Packet, 8, 10));
        // Remove NetBIOS layer
        byte[] rawHeader = Arrays.copyOfRange(smb2Packet, 4, 4 + length);
        this.smb2Header = new Smb2Header(rawHeader);
    }
}
