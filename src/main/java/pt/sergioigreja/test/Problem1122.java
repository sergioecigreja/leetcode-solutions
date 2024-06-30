package pt.sergioigreja.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.*;

class Problem1122 {

    public static void main(String[] args) {
        Problem1122 problem1122 = new Problem1122();
        int[] arr1 = new int[] { 2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19 };
        int[] arr2 = new int[] { 2, 1, 4, 3, 9, 6 };

        System.out.println(
            Arrays.toString(problem1122.relativeSortArray(arr1, arr2))
        );
    }

    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        List<Integer> result = new ArrayList<>();
        List<Integer> rest = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr2.length; i++) {
            map.put(arr2[i], 0);
        }

        for (int i = 0; i < arr1.length; i++) {
            int value = arr1[i];
            if (map.containsKey(value)) {
                map.put(value, map.get(value) + 1);
            } else {
                rest.add(value);
            }
        }

        for (int i = 0; i < arr2.length; i++) {
            int key = arr2[i];
            int value = map.get(key);

            for (int j = 0; j < value; j++) {
                result.add(key);
            }
        }

        Collections.sort(rest);

        Stream<Integer> combinedStream = Stream.concat(
            result.stream(),
            rest.stream()
        );

        return combinedStream.mapToInt(i -> i).toArray();
    }
}
