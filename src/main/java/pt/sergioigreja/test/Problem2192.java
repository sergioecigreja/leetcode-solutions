package pt.sergioigreja.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Problem2192
 */
public class Problem2192 {

    public static void main(String[] args) {}

    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        List<List<Integer>> result = new ArrayList<>(n);

        for (int i = 0; i < n; i++) {
            result.add(new ArrayList<>());
        }

        for (int i = 0; i < edges.length; i++) {
            result.get(edges[i][1]).add(edges[i][0]);
        }

        boolean[] calculated = new boolean[n];

        for (int i = 0; i < n; i++) {
            calculateAncestors(result, i, calculated);
        }

        return result;
    }

    public List<Integer> calculateAncestors(
        List<List<Integer>> result,
        int current,
        boolean[] calculated
    ) {
        if (result.get(current).size() == 0) {
            calculated[current] = true;
            return result.get(current);
        }

        if (calculated[current]) return result.get(current);

        Set<Integer> set = new HashSet<>();
        for (int elem : result.get(current)) {
            set.addAll(calculateAncestors(result, elem, calculated));
        }

        calculated[current] = true;

        for (int elem : result.get(current)) {
            set.add(elem);
        }

        List<Integer> aux = new ArrayList<>(set);
        Collections.sort(aux);
        result.set(current, aux);
        return result.get(current);
    }
}
