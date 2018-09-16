package main.java.github.codingbondam.p6e.bitwise;

public class Insert {

    public static void print(int num, int k) {
        if (k == 0) {
            return;
        }
        k--;
        int mask = 1 << k;
        for (int i = k; i >= 0; i--) {
            int bit = (num & mask) > 0 ? 1 : 0;
            System.out.print(bit + " ");
            mask = mask >> 1;
        }
        System.out.println();
    }

    public static int insert(int n, int m, int i, int j) {
        //1|1|1|1|1|1|1|1|1
        //8|7|6|5|4|3|2|1|0
        int left = ~0 << j + 1;
        int right = (1 << i) - 1;
        int n_shifted = ((n << j - i + 1) & left) | (n & right);
        int m_shifted = m << i;
        return n_shifted | m_shifted;
    }

    /*
    public static int insert(int n, int m, int i, int j) {
        int nUntilI = n & ((1 << i) - 1);
        print(nUntilI, 16);
        int nLeftShiftedItoJ = (n << (j - i + 1)) & ~((1 << j + 1) - 1);
        print(nLeftShiftedItoJ, 16);
        int splitN = nUntilI | nLeftShiftedItoJ;
        int mLeftShiftedIntoItoJ = m << i;
        return splitN | mLeftShiftedIntoItoJ;
    }
    */

    public static void main(String[] args) {
//        print(((1 << 3) - 1), 16);
        print(39, 16);
//        insert(39, 5, 2, 4);
//        print(5, 16);
        print(insert(39, 5, 2, 4), 16);
    }
}
