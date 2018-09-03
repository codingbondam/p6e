package main.java.github.codingbondam.p6e.strings;

import java.util.ArrayList;
import java.util.List;

public class Strings {

    public static class Combinations {

        private char[] input;

        private char[] buffer;

        int pos = 0;

        public Combinations(char[] input) {
            this.input = input;
            buffer = new char[input.length];
        }

        public void combine() {
            combine(0);
        }

        private void combine(int start) {
            for (int i = start; i < input.length; i++) {
                buffer[pos] = input[i];
                print(buffer);
                pos++;
                if (start + 1 < input.length) {
                    combine(i + 1);
                    buffer[pos] = 0;
                }
                pos--;
            }
        }

    }

//    private StringBuilder out = new StringBuilder();
//
//    private final String in;
//
//    public Strings(String str) {
//        in = str;
//    }
//
//    public void combine() {
//        combine(0);
//    }
//
//    private void combine(int start) {
//        for(int i = start; i < in.length(); i++) {
//            out.append(in.charAt(i));
//            System.out.println(out);
//            if (i < in.length()) {
//                combine(i + 1);
//            }
//            out.setLength(out.length() - 1);
//        }
//    }

//    /**
//     * all combinations of length k for the input
//     * @param input
//     */
//    public static void combine(char[] input) {
//        combine(new char[input.length], 0, input, 0);
//    }
//
//    private static void combine(char[] combination, int cpos, char[] input, int ipos) {
//        for (int i = ipos; i < input.length; i++) {
//            combination[cpos] = input[i];
//            print(combination);
//            if (i < input.length) {
//                combine(combination, cpos + 1, input, i + 1);
//            }
//        }
//    }

    public static void permute(char[] input) {
        permute(input, new boolean[input.length], new char[input.length], 0);
    }

    private static void permute(char[] input, boolean[] used, char[] permutation, int pos) {
        if (pos == input.length) {
            System.out.println(permutation);
        }
        for (int i = 0; i < input.length; i++) {
            if (!used[i]) {
                permutation[pos] = input[i];
                used[i] = true;
                permute(input, used, permutation, pos + 1);
                used[i] = false;
            }
        }
    }

    public static String remove(String input, int remove) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            if (i != remove) {
                builder.append(input.substring(i, i + 1));
            }
        }
        return builder.toString();
    }

    public static List<String> perumute2(String input) {
        List<String> combinations = new ArrayList<>();
        List<String> remainingLetters = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            combinations.add(input.substring(i, i + 1));
            remainingLetters.add(remove(input, i));
        }
        for (int i = 1; i < input.length(); i++) {
            List<String> newCombinations = new ArrayList<>();
            List<String> newRemainingLetters = new ArrayList<>();
            for (int j = 0; j < combinations.size(); j++) {
                String combination = combinations.get(j);
                String remaining = remainingLetters.get(j);
                for (int k = 0; k < remaining.length(); k++) {
                    newCombinations.add(combination + remaining.substring(k, k + 1));
                    newRemainingLetters.add(remove(remaining, k));
                }
            }
            combinations = newCombinations;
            remainingLetters = newRemainingLetters;
        }
        return combinations;
    }


    public static int to(char[] str) {
        int i = 0;
        boolean negative = str[i] == '-';
        if (negative) {
            i++;
        }
        int ASCII_VALUE = 48;
        int num = 0;
        for (; i < str.length; i++) {
            num = num * 10 + (int) str[i] - ASCII_VALUE;
        }
        if (negative) {
            num = num * -1;
        }
        return num;

    }

    public static char[] from(int n) {
        boolean negative = n < 0;
        int k = 0;
        if (negative) {
            n = n * -1;
            k++;
        }
        int temp = n;
        while (temp > 0) {
           temp = temp / 10;
           k++;
        }
        char[] output = new char[k];
        int i = 0;
        int ASCII_VALUE = 48;
        while (n > 0) {
           output[i] = (char) (ASCII_VALUE + n % 10);
           n = n / 10;
           i++;
        }
        if (negative) {
           output[i] = '-';
        }
        reverse(output, 0 , output.length - 1);
        return output;
    }

    /**
     * reverses words in a string
     * @param input
     */
    public static char[] reverseWords(char[] input) {
        reverse(input, 0, input.length - 1);
        int i = 0;
        while (i < input.length) {
            if (input[i] != ' ') {
                int start = i;
                while (i < input.length && input[i] != ' ') {
                    i++;
                }
                int end = i - 1;
                reverse(input, start, end);
            } else {
                i++;
            }
        }
        return input;
    }

    private static void reverse(char[] string, int begin, int end) {
        int back = end, front = begin;
        while (front < back) {
            char temp = string[front];
            string[front] = string[back];
            string[back] = temp;
            front++;
            back--;
        }

    }


    public static char[] remove(char[] source, char[] remove) {

        // build a quick hash map for removable characters assuming they are ascii
        boolean[] rChars = new boolean[256];
        for (int i = 0; i < remove.length; i++) {
            rChars[(int) remove[i]] = true;
        }

        int read = 0, write = 0;

        for (; read < source.length; read++) {
            if (!rChars[(int) source[read]]) {
                source[write] = source[read];
                write++;
            }
        }

        for (; write < source.length; write++) {
            source[write] = 0;
            // https://docs.oracle.com/javase/specs/jls/se7/html/jls-5.html#jls-5.2
            // section 5.2
            // A narrowing primitive conversion may be used if the type of the variable is byte, short, or char, and the value of the constant expression is representable in the type of the variable.
        }

        return source;
    }


    public static void print(char[] string) {
        int i = 0;
        while (i < string.length && string[i] != 0) {
            System.out.print(string[i]);
            i++;
        }
        System.out.println();
    }

    public static void main(String[] args) {

//        print(remove(new char[]{'a', 'e', 'r', 'o', 'p', 'l', 'a', 'n', 'e'}, new char[]{'a', 'e'}));
//        print(remove(new char[]{'c', 'a', 'r'}, new char[]{'a'}));
//        print(reverseWords("i am good".toCharArray()));
//        print(reverseWords("i am  good".toCharArray()));
//        print(reverseWords("  i am  good  ".toCharArray()));
//        print(from(1092));
//        print(from(-22128));
//        System.out.println(to("-22128".toCharArray()));
//        System.out.println(to("123".toCharArray()));
//        for (String c : permute2("rama")) {
//            System.out.println(c);
//        }
//        permute("rama".toCharArray());
//        combine("abcd".toCharArray());
        Combinations c = new Combinations("abcd".toCharArray());
        c.combine();
    }

}
