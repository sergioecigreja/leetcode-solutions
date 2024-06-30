package pt.sergioigreja.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Problem826
 */
public class Problem826 {

    public static void main(String[] args) {
        Problem826 problem826 = new Problem826();
        int[] difficulty = new int[] { 2, 4, 6, 8, 10 };
        int[] profit = new int[] { 10, 20, 30, 40, 50 };
        int[] worker = new int[] { 4, 5, 6, 7 };

        System.out.println(
            problem826.maxProfitAssignment(difficulty, profit, worker)
        );
    }

    public int maxProfitAssignment(
        int[] difficulty,
        int[] profit,
        int[] workers
    ) {
        Job[] jobs = new Job[difficulty.length];
        int result = 0;

        for (int i = 0; i < jobs.length; i++) {
            jobs[i] = new Job(difficulty[i], profit[i]);
        }

        Arrays.sort(jobs);
        List<Range> ranges = process(jobs);
        System.out.println(Arrays.toString(ranges.toArray()));

        for (int worker : workers) {
            int low = 0;
            int high = ranges.size() - 1;
            int mid = low + (high - low) / 2;

            Range currentRange = ranges.get(mid);
            System.out.println("humm");

            System.out.println(mid);
            while (low < high) {
                System.out.println(mid);
                if (
                    worker >= currentRange.getStartingDifficulty() &&
                    worker <= currentRange.getEndingDifficulty()
                ) break;
                if (worker < currentRange.getStartingDifficulty()) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }

                mid = low + (high - low) / 2;
                currentRange = ranges.get(mid);
            }

            result += currentRange.getMaxProfit();
        }

        return result;
    }

    public List<Range> process(Job[] jobs) {
        List<Range> ranges = new ArrayList<>();
        int jobIndex = 0;
        int maxProfit = jobs[0].getProfit();

        for (int i = 0; i < jobs.length; i++) {
            if (maxProfit < jobs[i].getProfit()) {
                Range range = new Range(
                    jobs[jobIndex].getDifficulty(),
                    jobs[i].getDifficulty() - 1,
                    jobs[jobIndex].getProfit()
                );
                ranges.add(range);
                jobIndex = i;
                maxProfit = jobs[i].getProfit();
            }
        }
        ranges.add(
            new Range(
                jobs[jobIndex].getDifficulty(),
                jobs[jobs.length - 1].getDifficulty(),
                maxProfit
            )
        );
        return ranges;
    }

    class Range {

        private int startingDifficulty;
        private int endingDifficulty;
        private int maxProfit;

        public Range(
            int startingDifficulty,
            int endingDifficulty,
            int maxProfit
        ) {
            this.startingDifficulty = startingDifficulty;
            this.endingDifficulty = endingDifficulty;
            this.maxProfit = maxProfit;
        }

        @Override
        public String toString() {
            return String.format(
                "Starting Difficulty - %d | EndingDifficulty - %d | Max Profit - %d",
                this.startingDifficulty,
                this.endingDifficulty,
                this.maxProfit
            );
        }

        public int getStartingDifficulty() {
            return startingDifficulty;
        }

        public void setStartingDifficulty(int startingDifficulty) {
            this.startingDifficulty = startingDifficulty;
        }

        public int getEndingDifficulty() {
            return endingDifficulty;
        }

        public void setEndingDifficulty(int endingDifficulty) {
            this.endingDifficulty = endingDifficulty;
        }

        public int getMaxProfit() {
            return maxProfit;
        }

        public void setMaxProfit(int maxProfit) {
            this.maxProfit = maxProfit;
        }
    }

    class Job implements Comparable<Job> {

        private int difficulty;
        private int profit;

        public Job(int difficulty, int profit) {
            this.difficulty = difficulty;
            this.profit = profit;
        }

        @Override
        public String toString() {
            return String.format(
                "Difficulty - %d | Profit - %d",
                this.difficulty,
                this.profit
            );
        }

        public int getDifficulty() {
            return difficulty;
        }

        public void setDifficulty(int difficulty) {
            this.difficulty = difficulty;
        }

        public int getProfit() {
            return profit;
        }

        public void setProfit(int profit) {
            this.profit = profit;
        }

        @Override
        public int compareTo(Job o) {
            if (this.difficulty > o.getDifficulty()) {
                return 1;
            } else if (this.difficulty < o.getDifficulty()) {
                return -1;
            }
            return 0;
        }
    }
}
