package nl.budroid.netlogapi.protocols.smb2;

import lombok.Getter;
import nl.budroid.netlogapi.utils.ByteArrayConverter;

import java.util.Arrays;

/**
 * SMB2 Header implementation following specs.
 * See: https://docs.microsoft.com/en-us/openspecs/windows_protocols/ms-smb2/fb188936-5050-48d3-b350-dc43059638a4
 */
@Getter
public class Smb2Header {

    private short structureSize;
    private short creditCharge;
    private short channelSequence;
    private short reserved;
    private short command;

    public Smb2Header(byte[] headerBytes) {
        this.structureSize = ByteArrayConverter.toShort(Arrays.copyOfRange(headerBytes, 4, 6));
        this.creditCharge = ByteArrayConverter.toShort(Arrays.copyOfRange(headerBytes, 6, 8));
        this.channelSequence = ByteArrayConverter.toShort(Arrays.copyOfRange(headerBytes, 8, 10));
        this.reserved = ByteArrayConverter.toShort(Arrays.copyOfRange(headerBytes, 10, 12));
        this.command = ByteArrayConverter.toShort(Arrays.copyOfRange(headerBytes, 12, 14));
    }

}
