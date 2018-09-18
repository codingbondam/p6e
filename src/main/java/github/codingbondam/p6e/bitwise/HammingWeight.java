package main.java.github.codingbondam.p6e.bitwise;

public class HammingWeight {

    public static int hammingWeight(int n) {

        int mask = 1;
        int count = 0;
        while(n > 0) {
            if ((n & mask) > 0) {
                count++;
            }
            n = n >> 1;
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(hammingWeight(-1 * (int) Math.pow(2, 31)));
    }
}
