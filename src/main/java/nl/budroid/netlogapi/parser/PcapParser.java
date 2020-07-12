package nl.budroid.netlogapi.parser;

import io.pkts.Pcap;
import io.pkts.buffer.Buffer;
import io.pkts.packet.TCPPacket;
import io.pkts.protocol.Protocol;
import nl.budroid.netlogapi.protocols.ProtocolIdentifier;
import nl.budroid.netlogapi.protocols.ProtocolIdentifiers;
import nl.budroid.netlogapi.protocols.smb2.Smb2;
import nl.budroid.netlogapi.protocols.smb2.Smb2Identifier;

import java.io.IOException;

public class PcapParser {

    public static void parse(String fileName) throws IOException {
        final Pcap pcap = Pcap.openStream(fileName);

        pcap.loop(packet -> {
            if (packet.hasProtocol(Protocol.TCP)) {
                TCPPacket tcpPacket = (TCPPacket) packet.getPacket(Protocol.TCP);
                Buffer payload = tcpPacket.getPayload();
                ProtocolIdentifier protocolIdentifier = new Smb2Identifier();

                for (ProtocolIdentifier p : new ProtocolIdentifiers().getIdentifiers()){

                }


                if (protocolIdentifier.identify(tcpPacket)) {
                    Smb2 smb2 = new Smb2(payload.getArray());
                    System.out.println(smb2.getSmb2Header().getCommand());
                }
            }
            return true;
        });
    }


}
