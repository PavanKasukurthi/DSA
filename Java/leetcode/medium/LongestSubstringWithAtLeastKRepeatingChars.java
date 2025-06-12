package Java.leetcode.medium;

import java.util.*;
import java.util.stream.*;

public class LongestSubstringWithAtLeastKRepeatingChars {
    public static void main(String[] args) {
        System.out.println(longestSubstring("aaabb", 3));
    }

    public static int longestSubstring(String str, int k) {

        if (str.length() < k)
            return 0;

        Map<Character, Long> freqMap = str.chars().mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()));

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (freqMap.get(ch) < k) {
                int l1 = longestSubstring(str.substring(0, i), k);
                int l2 = longestSubstring(str.substring(i + 1), k);

                return Math.max(l1, l2);
            }
        }

        return str.length();
    }
}