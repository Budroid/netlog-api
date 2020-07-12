package nl.budroid.netlogapi.protocols.smb2;

import io.pkts.buffer.Buffer;
import io.pkts.packet.TCPPacket;
import nl.budroid.netlogapi.protocols.ProtocolIdentifier;
import nl.budroid.netlogapi.utils.PayloadUtil;

public class Smb2Identifier extends ProtocolIdentifier {

    private static final String HEX_IDENTIFIER = "FE534D42";
    private static final int PORT_NUMBER = 445;

    @Override
    public boolean identify(TCPPacket tcpPacket) {
        boolean identified = false;
        Buffer payload = tcpPacket.getPayload();
        if ((tcpPacket.getDestinationPort() == PORT_NUMBER || tcpPacket.getSourcePort() == PORT_NUMBER) && payload != null && PayloadUtil.hasIdentifier(payload.getArray(), HEX_IDENTIFIER)) {
            identified = true;
        }
        return identified;
    }
}
