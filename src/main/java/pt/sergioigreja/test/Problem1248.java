package pt.sergioigreja.test;

/**
 * Problem1248
 */

public class Problem1248 {

    public static void main(String[] args) {
        Problem1248 problem1248 = new Problem1248();
        int[] nums = new int[] { 2, 2, 2, 1, 2, 2, 1, 2, 2, 2 };
        int k = 2;

        System.out.println(problem1248.numberOfSubarrays(nums, k));
    }

    public int numberOfSubarrays(int[] nums, int k) {
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] % 2 == 0 ? 0 : 1;
        }

        int i = 0;
        int result = 0;
        while (i < nums.length) {
            int cumSum = 0;
            for (int j = i; j < nums.length; j++) {
                cumSum += nums[j];
                if (cumSum == k) {
                    result += 1;
                }
            }
            i += 1;
        }

        return result;
    }
}
