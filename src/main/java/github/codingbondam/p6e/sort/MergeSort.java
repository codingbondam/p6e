package main.java.github.codingbondam.p6e.sort;

public class MergeSort {

    public static int[] sort(int[] data) {
        if (data.length <= 1) {
            return data;
        }
        int center = data.length / 2;
        int[] left = new int[center];
        int[] right = new int[data.length - center];
        System.arraycopy(data, 0, left, 0, center);
        System.arraycopy(data, center, right, 0, data.length - center);
        left = sort(left);
        right = sort(right);
        return merge(left, right);
    }

    private static int[] merge(int[] left, int[] right) {
        int lnext = 0, rnext = 0, ptr = 0;
        int[] output = new int[left.length + right.length];
        while(lnext < left.length && rnext < right.length) {
            if (left[lnext] < right[rnext]) {
                output[ptr] = left[lnext];
                ptr++;
                lnext++;
            } else {
                output[ptr] = right[rnext];
                ptr++;
                rnext++;
            }
        }
        while (lnext < left.length) {
            output[ptr] = left[lnext];
            ptr++;
            lnext++;
        }
        while (rnext < right.length) {
            output[ptr] = right[rnext];
            ptr++;
            rnext++;
        }
        return output;
    }

    public static void print(int[] data) {
        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i]);
        }
    }

    public static void main(String[] args) {
        int[] data = new int[] { 6, 5, 3, 2, 10, 8};
        print(sort(data));
    }

}
