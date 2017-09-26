package bit;

public class Bit {
    public static byte get(int subject, int index) {
        return (byte) (subject & (1 << index));
    }

    public static int set(int subject, int index) {
        return (subject | (1 << index));
    }

    public static int clear(int subject, int index) {
        return (subject & ~(1 << index));
    }
}
