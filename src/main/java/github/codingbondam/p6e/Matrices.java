package main.java.github.codingbondam.p6e;

public class Matrices {

    private static void visit(int[][] matrix, int level) {

        int iStart = level;
        int jStart = level;

        if (level == matrix.length - level - 1) {
            System.out.print(matrix[level][level] + " ");
            return;
        }

        int i = iStart;
        for(int j = jStart; j < matrix.length - jStart; j++) {
            System.out.print(matrix[i][j] + " ");
        }

        int j = matrix.length - jStart - 1;
        for(i = iStart + 1; i < matrix.length - iStart; i++) {
            System.out.print(matrix[i][j] + " ");
        }

        i = matrix.length - jStart - 1;
        for(j = matrix.length - jStart - 2; j >= jStart; j--) {
            System.out.print(matrix[i][j] + " ");
        }

        j = jStart;
        for(i = matrix.length - iStart - 2; i > iStart; i--) {
            System.out.print(matrix[i][j] + " ");
        }

        level++;
        if (level < (matrix.length + 1) / 2) {
            visit(matrix, level);
        }
    }

    public static void printClockwiseSpiral(int[][] matrix) {
        if (matrix == null) {
            return;
        }
        visit(matrix, 0);
    }

    public static int islands(int[][] matrix) {

        // input validation
        if (matrix == null) {
            return 0;
        }

        /*
        int cols = matrix[0].length;
        for (int i = 1; i < matrix.length; i++) {
            if (cols != matrix[i].length) {
                return 0;
            }
        }*/

        boolean[][] visited = new boolean[matrix.length][];
        for (int i = 0; i < matrix.length; i++) {
            visited[i] = new boolean[matrix[i].length];
        }

        int islands = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 1 && !visited[i][j]) {
                    islands++;
                    visit(matrix, visited, i, j);
                }
            }
        }
        return islands;
    }

    private static void visit(int[][] matrix, boolean[][] visited, int i, int j) {
        if (i < matrix.length && i >= 0 && j < matrix[i].length && j >= 0) {
            if (!visited[i][j] && matrix[i][j] == 1) {
                visited[i][j] = true;
                visit(matrix, visited, i - 1, j);
                visit(matrix, visited, i + 1, j);
                visit(matrix, visited, i, j - 1);
                visit(matrix, visited, i, j + 1);
            }
        }
    }

    public static void print(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
        }
    }

    public static void main(String[] args) {
        int[][] test1 = new int[][]{
                {1, 0, 1, 1, 1},
                {0, 1, 1, 1, 1},
                {1, 0, 1, 0, 1},
                {0, 1, 0, 1}
        };
        System.out.println(islands(test1));
        int[][] test2 = new int[][]{
                {0, 1, 0, 1, 0},
                {0, 0, 1, 1, 1},
                {1, 0, 0, 1, 0},
                {0, 1, 1, 0, 0},
                {1, 0, 1, 0, 1}
        };
        System.out.println(islands(test2));
        int[][] spiral = new int[][] {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };
        printClockwiseSpiral(spiral);
        System.out.println();
        print(spiral);
    }

}
