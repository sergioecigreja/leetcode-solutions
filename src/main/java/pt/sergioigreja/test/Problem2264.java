package pt.sergioigreja.test;

/**
 * Problem2264
 */
public class Problem2264 {

    public static void main(String[] args) {

    }

    public String largestGoodInteger(String num) {
        int result = -1;

        char prev = num.charAt(0);
        int count = 1;
        int currentNum = Character.getNumericValue(prev);
        for (int i = 1; i < num.length(); i++) {
            char c = num.charAt(i);
            if (c == prev) {
                currentNum = currentNum * 10 + Character.getNumericValue(c);
                count += 1;
                if (count >= 3) {
                    result = Math.max(result, currentNum);
                }
            } else {
                currentNum = Character.getNumericValue(c);
                count = 1;
            }
            prev = c;
        }

        if (result == -1)
            return "";

        return String.valueOf(result);
    }

    class Solution {
        public String largestGoodInteger(String num) {
            int result = -1;
            for (int i = 0; i + 2 < num.length(); i++) {
                if (num.charAt(i) == num.charAt(i + 1) && num.charAt(i) == num.charAt(i + 2)) {
                    result = Math.max(result, num.charAt(i) - '0');
                }
            }
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < 3; i++) {
                builder.append((char) (48 + result));
            }
            return result == -1 ? "" : builder.toString();
        }
    }
}