package pt.sergioigreja.test;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Problem502
 */
public class Problem502 {

    public static void main(String[] args) {
        Problem502 problem502 = new Problem502();

        int k = 2;
        int w = 0;
        int[] profits = new int[] { 1, 2, 3 };
        int[] capital = new int[] { 0, 1, 1 };

        System.out.println(
                problem502.findMaximizedCapital(k, w, profits, capital));
    }

    public int findMaximizedCapital(
            int k,
            int w,
            int[] profits,
            int[] capital) {
        boolean[] visited = new boolean[profits.length];
        Map<Situation, Integer> map = new HashMap<>();
        int result = recursive(k, w, profits, capital, visited, 0, 0, map, 0);

        System.out.println(Collections.singletonList(map));
        return result;
    }

    private int recursive(
            int k,
            int w,
            int[] profits,
            int[] capital,
            boolean[] visited,
            int completed,
            int projectIndex,
            Map<Situation, Integer> map,
            int networth) {
        if (completed == k) {
            return networth;
        }

        boolean[] visitedCopy = visited.clone();

        if (w >= capital[projectIndex]) {
            w -= capital[projectIndex];
            w += profits[projectIndex];
            visitedCopy[projectIndex] = true;
            networth += profits[projectIndex];
        }

        networth = networth + w;

        Situation s = new Situation(k, w, visitedCopy, projectIndex, networth);

        if (map.containsKey(s)) {
            return map.get(s);
        }

        for (int i = 0; i < profits.length; i++) {
            if (i != projectIndex && !visited[i]) {
                networth = Math.max(
                        networth,
                        recursive(
                                k,
                                w,
                                profits,
                                capital,
                                visitedCopy,
                                visitedCopy[projectIndex] ? completed + 1 : completed,
                                i,
                                map,
                                networth));
            }
        }

        map.put(s, networth);

        return networth;
    }

    class Situation {

        private int k;
        private int w;
        private boolean[] visited;
        private int projectIndex;
        private int networth;

        public int getNetworth() {
            return networth;
        }

        public void setNetworth(int networth) {
            this.networth = networth;
        }

        public Situation(
                int k,
                int w,
                boolean[] visited,
                int projectIndex,
                int networth) {
            this.k = k;
            this.w = w;
            this.visited = visited;
            this.projectIndex = projectIndex;
        }

        public int getProjectIndex() {
            return projectIndex;
        }

        public void setProjectIndex(int projectIndex) {
            this.projectIndex = projectIndex;
        }

        @Override
        public boolean equals(Object other) {
            Situation situation = (Situation) other;
            for (int i = 0; i < visited.length; i++) {
                if (visited[i] != situation.getVisited()[i])
                    return false;
            }
            return (this.k == situation.getK() &&
                    this.w == situation.getW() &&
                    this.networth == situation.getNetworth() &&
                    this.projectIndex == situation.getProjectIndex());
        }

        @Override
        public int hashCode() {
            int hashCode = 0;
            for (int i = 0; i < this.visited.length; i++) {
                if (visited[i]) {
                    hashCode += i + 1;
                }
            }
            return (hashCode +
                    k * 1000 +
                    11 +
                    w * 100 +
                    2 +
                    projectIndex * 10 +
                    networth);
        }

        @Override
        public String toString() {
            return String.format(
                    "k -> %d, w -> %d, visited -> %s\n",
                    k,
                    w,
                    Arrays.toString(visited));
        }

        public int getK() {
            return k;
        }

        public void setK(int k) {
            this.k = k;
        }

        public int getW() {
            return w;
        }

        public void setW(int w) {
            this.w = w;
        }

        public boolean[] getVisited() {
            return visited;
        }

        public void setVisited(boolean[] visited) {
            this.visited = visited;
        }
    }
}
