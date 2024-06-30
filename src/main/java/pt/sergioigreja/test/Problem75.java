package pt.sergioigreja.test;

import java.util.Arrays;

class Problem75 {

    public static void main(String[] args) {
        int[] arr = new int[] { 2, 0, 2, 1, 1, 0 };
        Problem75 problem75 = new Problem75();
        problem75.sortColors(arr);

        System.out.println(Arrays.toString(arr));
    }

    public void sortColors(int[] nums) {
        int red = 0;
        int white = 0;
        int blue = 0;

        for (int i = 0; i < nums.length; i++) {
            switch (nums[i]) {
                case 0:
                    red += 1;
                    break;
                case 1:
                    white += 1;
                    break;
                case 2:
                    blue += 1;
                    break;
                default:
                    break;
            }
        }

        int i = 0;
        while (i < nums.length) {
            if (i < red) {
                nums[i] = 0;
            } else if (i < red + white) {
                nums[i] = 1;
            } else {
                nums[i] = 2;
            }
            i += 1;
        }
    }
}
