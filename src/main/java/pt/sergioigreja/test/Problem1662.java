package pt.sergioigreja.test;

public class Problem1662 {
    public static void main(String[] args) {

    }

    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        StringBuilder sb = new StringBuilder();
        String word1String = "";

        for (String word : word1) {
            sb.append(word);
        }
        word1String = sb.toString();

        sb.setLength(0);
        for (String word : word2) {
            sb.append(word);
        }

        return word1String.equals(sb.toString());
    }

    public boolean arrayStringsAreEqualBestSolution(String[] word1, String[] word2) {
        return String.join("", word1).equals(String.join("", word2));
    }
}
