package pt.sergioigreja.test;

public class Problem1688 {
    public static void main(String[] args) {
        
    }

    public int numberOfMatches(int n) {
        int result = 0;

        while (n > 2) {
            if (n % 2 == 0) {
                result += n/2;
                n = n/2;
            }else {
                result += (n-1)/2;
                n = n/2 + 1;
            }
        }

        return result;
    }
}
