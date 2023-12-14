package pt.sergioigreja.test;

public class Problem2482 {
    public int[][] onesMinusZeros(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[] numOnesRow = new int[m];
        int[] numOnesCol = new int[n];

        int[][] result = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    numOnesRow[i] += 1;
                    numOnesCol[j] += 1;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                result[i][j] = numOnesRow[i] + numOnesCol[j] - (m - numOnesRow[i]) - (n - numOnesCol[j]);
            }
        }

        return result;

    }
}
