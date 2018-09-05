package main.java.github.codingbondam.p6e.arrays;

import java.util.HashMap;
import java.util.Map;

public class CountingPairs {

    public static Map<Integer, Boolean> buildHash(int[] data) {
        // todo a hash set would have been sufficient in this use case
        Map<Integer, Boolean> map = new HashMap<>();
        for (int i = 0; i < data.length; i++) {
            map.put(data[i], Boolean.TRUE);
        }
        return map;
    }

    public static int countAllPairs(int[] data, int k) {
        int counter = 0;
        Map<Integer, Boolean> lookUp = buildHash(data);
        for (int i = 0; i < data.length; i++) {
            if (lookUp.get(data[i] + k) != null) {
                counter++;
            }
        }
        return counter;
    }

    public static void main(String[] args) {
        int[] data = { 1, 7, 5, 9, 2, 12, 3};
        System.out.println(countAllPairs(data, 2));
    }
}
