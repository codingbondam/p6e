package main.java.github.codingbondam.p6e.arrays;

import java.util.HashSet;
import java.util.Set;

public class Sum {

    public static void pairs(int[] input, int k) {

        Set<Integer> lookup = new HashSet<>();

        // todo handle duplicates by using a wrapper class that has both position and integer value
        for(int i = 0; i < input.length; i++) {
        lookup.add(input[i]);
        }

        for(int i = 0; i < input.length; i++) {
            if(lookup.contains(k - input[i])) {
                lookup.remove(k - input[i]);
                lookup.remove(input[i]);
                System.out.println(input[i] + ", " + (k - input[i]));
            }
        }

    }

    public static void main(String[] args) {

        int[] test = new int[]{ 2, 3, 4, 7, 10, 5, 6};
        pairs(test, 13);

    }
}
