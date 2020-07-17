package nl.budroid.netlogapi.utils;

import java.util.Arrays;

public class PayloadUtil {

    public static boolean hasIdentifier(byte[] payload, String identifier) {
        String possibleIdentifier = HexUtils.bytesToHex(Arrays.copyOfRange(payload, 4, 8));
        return identifier.equals(possibleIdentifier);
    }

    // Lets do some magic, beers are tasting gooooood! :)
    public static int findOffset(byte[] payload, byte[] identifier){
        for (int i = 0; i < payload.length - identifier.length; i++) {
            if(Arrays.equals(Arrays.copyOfRange(payload, i, i+identifier.length), identifier)){
                return i;
            }
        }
        return -1;
    }
}
