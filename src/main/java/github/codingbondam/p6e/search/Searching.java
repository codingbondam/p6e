package main.java.github.codingbondam.p6e.search;

public class Searching {

    // can be implemented recursively but not necessarily efficient
    public static int search(int key, int[] data) {
        int start = 0;
        int end = data.length - 1;
        while (start <= end) {
            int center = start + (end - start) / 2;
            if (data[center] == key) {
                return center;
            } else if (data[center] > key) {
                end = center;
            } else {
                start = center + 1;
            }
        }
        throw new RuntimeException("Key not found!");
    }

    public static void main(String[] args) {
        System.out.println(search(5, new int[] { 5, 7, 9, 10, 12 }));
        System.out.println(search(7, new int[] { 5, 7, 9, 10, 12 }));
        System.out.println(search(9, new int[] { 5, 7, 9, 10, 12 }));
        System.out.println(search(10, new int[] { 5, 7, 9, 10, 12 }));
        System.out.println(search(12, new int[] { 5, 7, 9, 10, 12 }));
        try {
            search(20, new int[] { 10, 12, 5, 7, 9 });
        } catch (RuntimeException r) {
            System.out.println("Received exception as expected -> " + r.getMessage());
        }

    }

}
