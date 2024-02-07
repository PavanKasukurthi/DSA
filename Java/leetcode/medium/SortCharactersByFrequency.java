package Java.leetcode.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SortCharactersByFrequency{
    public static void main(String[] args) {
        System.out.println(frequencySort("tree"));
    }

    public static String frequencySort(String s) {

      Map<Character, Integer> charCount = new HashMap<>();

        for (char c : s.toCharArray()) {
           charCount.merge(c, 1, Integer::sum);
        }

        List<Character> sortedChars = new ArrayList<>(charCount.keySet());

        Collections.sort(sortedChars, (a, b) -> charCount.get(b) - charCount.get(a));

        StringBuilder result = new StringBuilder();

        for (char c : sortedChars) {
            result.append(String.valueOf(c).repeat(charCount.get(c)));
        }

        return result.toString();
    }
}