package pt.sergioigreja.test;

public class Problem779 {
    public static void main(String[] args) {
        System.out.println(1 ^ 3);
    }

    public int kthGrammar(int n, int k) {
        if (n == 1)
            return 0;

        int parent;
        if (k % 2 == 0) {
            parent = kthGrammar(n - 1, k / 2);
            return parent == 1 ? 0 : 1;
        } else {
            parent = kthGrammar(n - 1, k / 2 + 1);
            return parent;
        }
    }
}
