package pt.sergioigreja.test;

import java.util.ArrayList;
import java.util.List;

public class Problem118 {
    public static void main(String[] args) {

    }

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        helper(numRows - 1, result);
        return result;
    }

    private void helper(int numRows, List<List<Integer>> result) {
        List<Integer> row = new ArrayList<>(List.of(1));
        if (numRows < 1) {
            result.add(row);
            return;
        } else {
            helper(numRows - 1, result);
            List<Integer> prevRow = result.get(numRows - 1);

            for (int i = 0; i + 1 < prevRow.size(); i++) {
                row.add(prevRow.get(i) + prevRow.get(i + 1));
            }

            row.add(1);
            result.add(row);
        }
    }
}
