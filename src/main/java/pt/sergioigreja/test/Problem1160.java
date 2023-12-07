package pt.sergioigreja.test;

import java.util.HashMap;
import java.util.Map;

/**
 * Problem1160
 */
public class Problem1160 {
    public static void main(String[] args) {
        String[] input = new String[] { "cat", "bt", "hat", "tree" };
        String chars = "atach";

        System.out.println(new Problem1160().countCharacters(input, chars));
    }

    public int countCharacters(String[] words, String chars) {
        int result = 0;
        Map<Character, Integer> characterCount = new HashMap<>();
        for (char c : chars.toCharArray()) {
            characterCount.put(c, characterCount.getOrDefault(c, 0) + 1);
        }

        Map<Character, Integer> wordsCharacterCount;
        for (String word : words) {
            wordsCharacterCount = new HashMap<>();
            boolean fits = true;
            for (char c : word.toCharArray()) {
                if (!characterCount.containsKey(c)) {
                    fits = false;
                    break;
                }

                wordsCharacterCount.put(c, wordsCharacterCount.getOrDefault(c, 0) + 1);
                if (characterCount.get(c) < wordsCharacterCount.get(c)) {
                    fits = false;
                    break;
                }
            }
            if (fits) {
                result += word.length();
            }
        }
        return result;
    }
}