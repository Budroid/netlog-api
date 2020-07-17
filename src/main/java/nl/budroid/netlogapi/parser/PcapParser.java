package nl.budroid.netlogapi.parser;

import io.pkts.Pcap;
import io.pkts.buffer.Buffer;
import io.pkts.packet.TCPPacket;
import io.pkts.protocol.Protocol;
import nl.budroid.netlogapi.protocols.ProtocolIdentifier;
import nl.budroid.netlogapi.protocols.smb2.Smb2Analyzer;
import nl.budroid.netlogapi.protocols.smb2.Smb2Identifier;

import java.io.IOException;

public class PcapParser {

    public static void parse(String fileName) throws IOException {
        final Pcap pcap = Pcap.openStream(fileName);
        Smb2Analyzer smbAnalyser = new Smb2Analyzer();

        pcap.loop(packet -> {
            if (packet.hasProtocol(Protocol.TCP)) {
                TCPPacket tcpPacket = (TCPPacket) packet.getPacket(Protocol.TCP);
                Buffer payload = tcpPacket.getPayload();
                // TODO find a solution to identify protocols for specific analysers

                ProtocolIdentifier protocolIdentifier = new Smb2Identifier();
                if (protocolIdentifier.identify(tcpPacket)) {
                    smbAnalyser.push(payload.getArray());
                }


            }
            return true;
        });
    }


}
