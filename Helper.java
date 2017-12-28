public class Helper {

    public static long bytesToLong(byte array[], int offset, int length) {
        long output = 0;

        for (int i = length - 1; i >= 0; i--) {
            output = output | ((array[offset + i] & 0xff) << (i * 8)) & 0xffffffffL;
        }

        return output;
    }
}
