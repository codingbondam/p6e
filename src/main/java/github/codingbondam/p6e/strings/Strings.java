package main.java.github.codingbondam.p6e.strings;

public class Strings {

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

        print(remove(new char[]{'a', 'e', 'r', 'o', 'p', 'l', 'a', 'n', 'e'}, new char[]{'a', 'e'}));
        print(remove(new char[]{'c', 'a', 'r'}, new char[]{'a'}));
        print(reverseWords("i am good".toCharArray()));
        print(reverseWords("i am  good".toCharArray()));
        print(reverseWords("  i am  good  ".toCharArray()));
        print(from(1092));
        print(from(-22128));
        System.out.println(to("-22128".toCharArray()));
        System.out.println(to("123".toCharArray()));
    }

}
