package main.java.github.codingbondam.p6e.bitwise;

public class Reverse {

    public static String bits(int n) {

        int mask = 1 << 31;
        StringBuilder builder = new StringBuilder();
        for (int i = 31; i >= 0; i--) {
            int bit = (n & mask) == 0 ? 0 : 1;
            builder.append(bit);
            builder.append(" ");
            mask = mask >>> 1;
        }
        return builder.toString();
    }

    public static int reverseBits(int n) {
        int mask = 1;
        int output = 0;
        // take each position from 0 to 31 and set it at 0th position on output and move left
        for(int i = 0; i < 32; i++) {
            int d = (n & mask) == 0 ? 0 : 1;
            mask = mask << 1;
            output = output << 1;
            output = output | d;
        }

        return output;
    }

    public static void main(String[] args) {
//        print(-1 * (int) Math.pow(2, 31), 32);
//        System.out.println(new Reverse().reverseBits(-1 * (int) Math.pow(2, 31)));
//        System.out.println(bits(~((int) Math.pow(2, 31))));
//        System.out.println(~((int) Math.pow(2, 31)));
//        System.out.println(reverseBits(-2147483648));
        System.out.println(bits((-2 * 1024 * 1024 * 1024)));

    }
}
