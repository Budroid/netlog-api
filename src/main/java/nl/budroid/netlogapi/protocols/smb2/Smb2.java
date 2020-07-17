package nl.budroid.netlogapi.protocols.smb2;

import lombok.Getter;
import nl.budroid.netlogapi.utils.ByteArrayConverter;
import nl.budroid.netlogapi.utils.PayloadUtil;

import java.util.Arrays;


@Getter
public class Smb2 {

    private Smb2Header smb2Header;
    private byte[] smb2Payload;

    public Smb2(byte[] smb2Packet) {
        // Check the length of the header first
        short length = ByteArrayConverter.toShort(Arrays.copyOfRange(smb2Packet, 8, 10));
        // Remove the 4 bytes NetBIOS layer
        // TODO This should not be done here. smb2Packet should only contain SMB2 payload
        // TODO Create a offset finder, this can be reused
        byte[] rawHeader = Arrays.copyOfRange(smb2Packet, 4, 4 + length);
        this.smb2Header = new Smb2Header(rawHeader);
        this.smb2Payload = Arrays.copyOfRange(smb2Packet, 4 + length, smb2Packet.length);

    }

    public boolean hasNtlmSspLayer(){
        // TODO Magic number
        int offset = PayloadUtil.findOffset(this.smb2Payload, "NTLMSSP".getBytes());
        return offset != -1;
    }
}
