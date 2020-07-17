package nl.budroid.netlogapi.protocols.smb2;

import nl.budroid.netlogapi.protocols.ntlmssp.NtlmSspFase;

public class Smb2Analyzer {

    private NtlmSspFase ntlmSspFase;

    public void push(byte[] payload) {
        Smb2 smb2 = new Smb2(payload);
        Smb2Header smb2Header = smb2.getSmb2Header();
        System.out.println(smb2.hasNtlmSspLayer());
        if (smb2Header.getCommand() == 1) {
            if (smb2Header.isRequest()) {
                if (smb2Header.getSessionId() == 0) {
                    // NTLMSSP Negotiate request
                    System.out.println("NTLMSSP Negotiate request");
                    this.ntlmSspFase = NtlmSspFase.NEGOTIATION;
                } else {
                    // NTLMSSP Authentication request
                    System.out.println("NTLMSSP Authentication request");
                    this.ntlmSspFase = NtlmSspFase.AUTHENTICATION;
                }
            } else if (this.ntlmSspFase == NtlmSspFase.AUTHENTICATION) {
                // Last SMB2 session setup response
                // TODO Get the status
            } else {
                this.ntlmSspFase = NtlmSspFase.CHALLENGE;
                System.out.println("NTLMSSP challenge");
            }
        }


//        if smb2_command == 1 and is_request and pkt[SMB2_Header].SessionID == 0:
//        fase = 2
//      # NTLMSSP Authentication request
//        if smb2_command == 1 and is_request and pkt[SMB2_Header].SessionID > 0:
//        session_setup_request = SMB2_Session_Setup_Request(pkt[SMB2_Header])
//        packet_time = time.strftime(TIME_FORMAT, time.localtime(pkt.time))
//        fase = 3
//      # NTLMSSP Authentication response
//        if smb2_command == 1 and not is_request and fase == 3:
//        logon_state = "succesfull" if bytes(pkt[SMB2_Header])[8] == 0 else "failed"
//

    }


}
