package nl.budroid.netlogapi.protocols;

import io.pkts.packet.TCPPacket;

public abstract class ProtocolIdentifier {
    public abstract boolean identify(TCPPacket tcpPacket);
}
