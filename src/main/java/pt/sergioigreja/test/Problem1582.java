package pt.sergioigreja.test;

public class Problem1582 {

    public int numSpecial(int[][] mat) {
        int[] rows = new int[mat.length];
        int[] cols = new int[mat[0].length];

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 1) {
                    rows[i] += 1;
                    cols[j] += 1;
                }
            }
        }

        int result = 0;
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 1) {
                    if (rows[i] == 1 && cols[j] == 1) {
                        result += 1;
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] line1 = { 1, 0, 0 };
        int[] line2 = { 0, 0, 1 };
        int[] line3 = { 1, 0, 0 };

        int[][] mat = { line1, line2, line3 };
        System.out.println(new Problem1582().numSpecial(mat));
    }
}
