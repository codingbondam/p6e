package main.java.github.codingbondam.p6e.sort;

public class InsertionSort {


    public void sort(int[] input) {

        for (int subject = 1; subject < input.length; subject++) {
            for (int target = 0; target < subject; target++) {
                if (input[subject] < input[target]) {
                    insert(input, subject, target);
                    break;
                }
            }
        }
    }

    private void insert(int[] input, int from, int to) {
        int temp = input[from];
        for (int i = from; i > to; i--) {
            input[i] = input[i - 1];
        }
        input[to] = temp;
    }

    public static void print(int[] data) {
        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i]);
        }
    }

    public static void main(String[] args) {

        int[] data = new int[]{ 5, 3, 6, 1, 9, 2};
        new InsertionSort().sort(data);
        print(data);
    }

}
