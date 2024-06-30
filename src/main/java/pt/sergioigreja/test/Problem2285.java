package pt.sergioigreja.test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Problem2285
 */
public class Problem2285 {

    public static void main(String[] args) {
        Problem2285 problem2285 = new Problem2285();
    }

    public long maximumImportance(int n, int[][] roads) {
        long result = 0;
        long[] cityConnections = new long[n];
        for (int i = 0; i < roads.length; i++) {
            cityConnections[roads[i][0]] += 1;
            cityConnections[roads[i][1]] += 1;
        }

        Arrays.sort(cityConnections);
        int importance = 1;
        for (long connections : cityConnections) {
            result += importance * connections;
            importance += 1;
        }

        return result;
    }

    class CityConnections {

        private int connections;
        private int city;

        public CityConnections(int connections, int city) {
            this.connections = connections;
            this.city = city;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null) return false;
            if (getClass() != obj.getClass()) return false;

            final CityConnections other = (CityConnections) obj;
            return (
                this.city == other.getCity() &&
                this.connections == other.getConnections()
            );
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + city + connections;
            return result;
        }

        public int getConnections() {
            return connections;
        }

        public void setConnections(int importance) {
            this.connections = importance;
        }

        public int getCity() {
            return city;
        }

        public void setCity(int city) {
            this.city = city;
        }
    }
}
