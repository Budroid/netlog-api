package nl.budroid.netlogapi.utils;

import java.util.Arrays;

public class PayloadUtil {

    public static boolean hasIdentifier(byte[] payload, String identifier) {
        String possibleIdentifier = HexUtils.bytesToHex(Arrays.copyOfRange(payload, 4, 8));
        return identifier.equals(possibleIdentifier);
    }
}
