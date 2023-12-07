package pt.sergioigreja.test;

public class Problem1716 {
    public static void main(String[] args) {
        Problem1716 problem1716 = new Problem1716();
        System.out.println(problem1716.totalMoney(11));
    }

    public int totalMoney(int n) {
        int week = n / 7;
        int day = n % 7;

        int result = calculateForWeek(week);
        if (day == 0)
            return result;

        week += 1;

        while (day != 0) {
            result += week;
            day -= 1;
            week += 1;
        }

        return result;
    }

    public int calculateForWeek(int week) {
        int result = 0;

        for (int i = 0; i < week; i++) {
            int increment = i * 7;
            result += 28 + increment;
        }

        return result;
    }
}
