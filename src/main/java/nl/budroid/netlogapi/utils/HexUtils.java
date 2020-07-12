package nl.budroid.netlogapi.utils;

import java.io.UnsupportedEncodingException;

public final class HexUtils {

    public static String formatHexDump(byte[] array, int offset, int length) {
        final int width = 16;
        StringBuilder builder = new StringBuilder();

        for (int rowOffset = offset; rowOffset < offset + length; rowOffset += width) {
            builder.append(String.format("%06d:  ", rowOffset));
            for (int index = 0; index < width; index++) {
                if (rowOffset + index < array.length) {
                    builder.append(String.format("%02x ", array[rowOffset + index]));
                } else {
                    builder.append("   ");
                }
            }
            if (rowOffset < array.length) {
                int asciiWidth = Math.min(width, array.length - rowOffset);
                builder.append("  |  ");
                try {
                    builder.append(new String(array, rowOffset, asciiWidth, "UTF-8").replaceAll("\r\n", " ").replaceAll("\n", " "));
                } catch (UnsupportedEncodingException ignored) {
                    // Als UTF-8 niet beschikbaar is als encoding dan kunnen we niet veel doen.
                }
            }
            builder.append(String.format("%n"));
        }
        return builder.toString();
    }

    public static String bytesToHex(byte[] bytes) {
        StringBuilder result = new StringBuilder();
        for (byte aByte : bytes) {
            result.append(String.format("%02X", aByte));
        }
        return result.toString();
    }




}
