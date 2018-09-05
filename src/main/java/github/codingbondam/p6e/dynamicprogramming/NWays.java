package main.java.github.codingbondam.p6e.dynamicprogramming;

public class NWays {

    /**
     * nways to climb k steps if you can climb 1, 2 or 3 steps at a time
     * @param k
     * @return
     */
    public static int nways(int k, int[] memo) {
        int rVal;
        if (k == 0) {
            rVal = 1;
        } else if (k == 1) {
            int m = memo[k - 1];
            if (m == 0) {
                m = nways(k - 1, memo);
            }
            rVal = m;
        } else if (k == 2) {
            int m1 = memo[k - 1];
            if (m1 == 0) {
                m1 = nways(k - 1, memo);
            }
            int m2 = memo[k - 2];
            if (m2 == 0) {
                m2 = nways(k - 2, memo);
            }
            rVal = m1 + m2;
        } else {
            int m1 = memo[k - 1];
            if (m1 == 0) {
                m1 = nways(k - 1, memo);
            }
            int m2 = memo[k - 2];
            if (m2 == 0) {
                m2 = nways(k - 2, memo);
            }
            int m3 = memo[k - 3];
            if (m3 == 0) {
                m3 = nways(k - 3, memo);
            }
            rVal = m1 + m2 + m3;
        }
        memo[k] = rVal;
        return rVal;
    }

    public static void main(String[] args) {
        System.out.println(nways(5, new int[5 + 1]));
    }
}
