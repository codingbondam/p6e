package main.java.github.codingbondam.p6e;

public class Utils {

    public static void assertEquals(Object expected, Object actual) {
        if (!expected.toString().equals(actual.toString())) {
            throw new AssertionError(expected.toString() + " is not equal to " + actual.toString());
        }
    }
}
