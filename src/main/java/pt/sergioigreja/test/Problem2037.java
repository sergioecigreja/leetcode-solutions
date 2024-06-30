package pt.sergioigreja.test;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

class Problem2037 {

    public static void main(String[] args) {
        Problem2037 problem2037 = new Problem2037();
        int[] seats = new int[] { 4, 1, 5, 9 };
        int[] students = new int[] { 1, 3, 2, 6 };

        System.out.println(problem2037.minMovesToSeat2(seats, students));
    }

    public int minMovesToSeat2(int[] seats, int[] students) {
        int result = 0;
        PriorityQueue<Integer> pqSeats = new PriorityQueue<Integer>(
            Collections.reverseOrder()
        );
        PriorityQueue<Integer> pqStudents = new PriorityQueue<Integer>(
            Collections.reverseOrder()
        );

        for (int i = 0; i < seats.length; i++) {
            pqSeats.add(seats[i]);
            pqStudents.add(students[i]);
        }

        do {
            result += Math.abs(pqSeats.poll() - pqStudents.poll());
        } while (pqSeats.peek() != null);

        return result;
    }

    public int minMovesToSeat(int[] seats, int[] students) {
        int[] differences = new int[101];
        for (int i = 0; i < seats.length; i++) {
            differences[seats[i]] += 1;
        }

        for (int j = 0; j < students.length; j++) {
            differences[students[j]] -= 1;
        }

        System.out.println(Arrays.toString(differences));

        int result = 0;
        for (int i = 0; i < differences.length; i++) {
            int diff = differences[i];
        }

        return 0;
    }
}
