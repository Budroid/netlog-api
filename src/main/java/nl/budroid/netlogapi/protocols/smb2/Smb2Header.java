package nl.budroid.netlogapi.protocols.smb2;

import lombok.Getter;
import nl.budroid.netlogapi.utils.ByteArrayConverter;
import java.util.Arrays;

/**
 * SMB2 Header implementation following specs.
 * See: https://docs.microsoft.com/en-us/openspecs/windows_protocols/ms-smb2/fb188936-5050-48d3-b350-dc43059638a4
 *
 * @author Robert-Jan Buddenbohmer
 */
@Getter
public class Smb2Header {

    private short structureSize;
    private short creditCharge;
    private short channelSequence;
    private short reserved;
    private short command;
    private short creditsReqResp;
    private int flags;
    private int chainOffset;
    private long messageId;
    private int processId;
    private int treeId;
    private long sessionId;

    public Smb2Header(byte[] headerBytes) {
        this.structureSize = ByteArrayConverter.toShort(Arrays.copyOfRange(headerBytes, 4, 6));
        this.creditCharge = ByteArrayConverter.toShort(Arrays.copyOfRange(headerBytes, 6, 8));
        this.channelSequence = ByteArrayConverter.toShort(Arrays.copyOfRange(headerBytes, 8, 10));
        this.reserved = ByteArrayConverter.toShort(Arrays.copyOfRange(headerBytes, 10, 12));
        this.command = ByteArrayConverter.toShort(Arrays.copyOfRange(headerBytes, 12, 14));
        this.creditsReqResp = ByteArrayConverter.toShort(Arrays.copyOfRange(headerBytes, 14, 16));
        this.flags = ByteArrayConverter.toInt(Arrays.copyOfRange(headerBytes, 16, 20));
        this.chainOffset = ByteArrayConverter.toInt(Arrays.copyOfRange(headerBytes, 20, 24));
        this.messageId = ByteArrayConverter.toInt(Arrays.copyOfRange(headerBytes, 24, 32));
        this.processId = ByteArrayConverter.toInt(Arrays.copyOfRange(headerBytes, 32, 36));
        this.treeId = ByteArrayConverter.toInt(Arrays.copyOfRange(headerBytes, 36, 40));
        this.sessionId = ByteArrayConverter.toInt(Arrays.copyOfRange(headerBytes, 40, 48));
    }

    public boolean isRequest(){
        // The Least Significant Bit indicates if we are dealing with a request (0) or a response (1)
        return (this.flags & 1) == 0;
    }

}
