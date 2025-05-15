package Java.leetcode.easy;

import java.util.*;
import java.util.stream.*;

public class FirstUniqChar {

    public static void main(String[] args) {
        String s = "loveleetcode";
        // System.out.println(firstUniqChar(s));
        System.out.println(firstUniqCharUsingStreams(s));
    }

    public static int firstUniqChar(String s) {
        HashMap<Character, Integer> freqCounter = new HashMap<>();

        for (char ch : s.toLowerCase().toCharArray()) {
            freqCounter.merge(ch, 1, Integer::sum);
        }

        for (int i = 0; i < s.length(); i++) {
            if (freqCounter.get(s.charAt(i)) == 1)
                return i;
        }

        return -1;
    }

    // USING STREAMS
    public static char firstUniqCharUsingStreams(String str) {
        return str.chars().mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(c -> c, LinkedHashMap::new, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() == 1)
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse('\0');
    }
}
