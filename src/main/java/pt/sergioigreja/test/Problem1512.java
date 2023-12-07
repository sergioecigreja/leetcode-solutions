package pt.sergioigreja.test;

import java.util.HashMap;

public class Problem1512 {
    public static void main(String[] args) {

    }

    public int numIdenticalPairs(int[] nums) {
        int result = 0;

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j])
                    result += 1;
            }
        }

        return result;
    }

    /**
     * Just counts the occurrences of the same element in the array
     * 
     * @param nums
     * @return
     */
    public int numIdenticalPairsBestSolution(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        int sum = 0;

        for (int i = 0; i < n; i++) {
            if (map.containsKey(nums[i])) {
                sum += map.get(nums[i]);
            }
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        return sum;
    }
}
