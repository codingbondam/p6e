package main.java.github.codingbondam.p6e.arrays;

import com.sun.deploy.util.SystemUtils;

public class Max {

    public static int max(int[] input) {
        // todo handle empty input or null input
        if (input.length == 1) {
            return input[0];
        }

        int center = input.length / 2;
        if (input[center - 1] > input[center]) {
            int[] left = new int[center];
            System.arraycopy(input, 0, left, 0, center);
            return max(left);
        } else {
            int[] right = new int[input.length - center];
            System.arraycopy(input, center, right, 0, input.length - center);
            return max(right);
        }
        // todo handle invalid input if we happen to find two numbers to be same
    }

    public static void main(String[] args) {

        int[] test = new int[3];
        test[0] = 1;
        test[1] = 2;
        test[2] = 1;
        System.out.println(max(test));

    }
}
