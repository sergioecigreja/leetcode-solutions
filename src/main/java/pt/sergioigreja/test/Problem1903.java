package pt.sergioigreja.test;

/**
 * Problem1903
 */
public class Problem1903 {

    public static void main(String[] args) {

    }

    public String largestOddNumber(String num) {
        String result = "";
        for (int i = num.length() - 1; i >= 0; i--) {
            if (Character.getNumericValue(num.charAt(i)) % 2 != 0) {
                return num.substring(0, i + 1);
            }
        }

        return result;
    }

    // dont need to convert from char to digit
    public String largestOddNumberBest(String num) {
        String result = "";
        for (int i = num.length() - 1; i >= 0; i--) {
            if (num.charAt(i) % 2 != 0) {
                return num.substring(0, i + 1);
            }
        }

        return result;
    }

}