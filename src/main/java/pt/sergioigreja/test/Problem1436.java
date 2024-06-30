package pt.sergioigreja.test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class Problem1436 {

    public String destCity(List<List<String>> paths) {
        Map<String, Integer> map = new HashMap<>();
        map.put(paths.get(0).get(0), 1);
        for (List<String> cities : paths) {
            String start = cities.get(0);
            String destination = cities.get(1);
            map.put(start, map.getOrDefault(start, 1) + 1);
            map.put(destination, map.getOrDefault(destination, 0) + 1);
        }

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }

        return paths.get(0).get(1);
    }

    // better
    public String destCity2(List<List<String>> paths) {
        int l = paths.size();
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < l; i++) {
            set.add(paths.get(i).get(0));
        }
        for (int i = 0; i < l; i++) {
            if (!set.contains(paths.get(i).get(1)))
                return paths.get(i).get(1);
        }
        return "";
    }
}
