package pt.sergioigreja.test;

public class Problem1287 {
    public int findSpecialInteger(int[] arr) {
        int currentNumber = arr[0];
        int count = 1;
        int maxCount = 0;
        int maxNumber = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (currentNumber == arr[i]) {
                count += 1;
            } else {
                currentNumber = arr[i];
                count = 1;
            }
            if (count > maxCount) {
                maxNumber = arr[i];
                maxCount = count;
            }
        }

        return maxNumber;
    }
}
