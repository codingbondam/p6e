package main.java.github.codingbondam.p6e.sort;

public class QuickSort {

    public static void sort(int[] data) {
        sort(data, 0, data.length - 1);
    }

    private static void sort(int[] data, int begin, int end) {
        if (begin >= end) {
            return;
        }
        int pivot = (end - begin)/2 + begin;
        int left = begin;
        while (left < pivot) {
            if (data[left] < data[pivot]) {
                left++;
            } else {
                if (left == pivot - 1) {
                    int temp = data[pivot - 1];
                    data[pivot - 1] = data[pivot];
                    data[pivot] = temp;
                } else {
                    int temp = data[pivot - 1];
                    data[pivot - 1] = data[pivot];
                    data[pivot] = data[left];
                    data[left] = temp;
                }
                pivot--;
            }
        }
        int right = end;
        while (right > pivot) {
            if (data[right] > data[pivot]) {
                right--;
            } else {
                if (right == pivot + 1) {
                    int temp = data[pivot + 1];
                    data[pivot + 1] = data[pivot];
                    data[pivot] = temp;
                } else {
                    int temp = data[pivot + 1];
                    data[pivot + 1] = data[pivot];
                    data[pivot] = data[right];
                    data[right] = temp;
                }
                pivot++;
            }
        }
        sort(data, begin, pivot - 1);
        sort(data, pivot + 1, end);
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
