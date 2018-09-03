package main.java.github.codingbondam.p6e.sort;

public class SelectionSort {

    public static void sort(int[] data) {
        // for each position say subject position in the array, parse through all positions to its right and swap if the number at a position is lower than the subject position
        for (int i = 0; i < data.length; i++) {
            for (int j = i + 1; j < data.length; j++) {
                if (data[j] < data[i]) {
                    int temp = data[j];
                    data[j] = data[i];
                    data[i] = temp;
                }
            }
        }
    }

    public static void print(int[] data) {
        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i]);
        }
    }

    public static void main(String[] args) {
        int[] data = new int[] { 6, 5, 3, 2, 10, 8};
        sort(data);
        print(data);
    }

}
