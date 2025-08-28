package Java.leetcode.medium;

import java.util.Arrays;

public class DiagonalTraverse {
    public static void main(String[] args) {
        int[][] mat = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        System.out.println(Arrays.toString(findDiagonalOrder(mat)));
    }

    public static int[] findDiagonalOrder(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        int[] result = new int[m * n];

        int row = 0, col = 0;

        for (int i = 0; i < m * n; i++) {
            result[i] = mat[row][col];

            if ((row + col) % 2 == 0) { // even diagonal
                if (col == n - 1)
                    row++;
                else if (row == 0)
                    col++;
                else {
                    row--;
                    col++;
                }
            } else { // odd diagonal
                if (row == m - 1)
                    col++;
                else if (col == 0)
                    row++;
                else {
                    row++;
                    col--;
                }
            }
        }

        return result;
    }
}
