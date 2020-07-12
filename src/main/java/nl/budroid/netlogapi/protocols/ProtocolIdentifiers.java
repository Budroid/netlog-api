package nl.budroid.netlogapi.protocols;

import nl.budroid.netlogapi.protocols.smb2.Smb2Identifier;

import java.util.ArrayList;
import java.util.List;

public class ProtocolIdentifiers   {

    List<Class<? extends ProtocolIdentifier>> identifiers = new ArrayList<>();

    public ProtocolIdentifiers(){
//        identifiers.add(Smb2Identifier.class);
    }

//    public List<ProtocolIdentifier> getIdentifiers(){
//
//    }

}
