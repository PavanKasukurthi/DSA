package Java.leetcode.easy;

import java.util.*;
import java.util.stream.*;

// 3442. Maximum Difference Between Even and Odd Frequency I

public class MaximumDifferenceBetweenEvenAndOddFrequencyI {
    public static void main(String[] args) {
        System.out.println();
        System.out.println(maxDifference("mmsmsym"));
    }

    public static int maxDifference(String s) {

        Map<Character, Integer> freq = s.chars().mapToObj(c -> (char) c)
                .collect(Collectors.toMap(c -> c, c -> 1, Integer::sum));

        int minEven = s.length(), maxOdd = 1;

        for (int value : freq.values()) {
            if (value % 2 != 0) {
                maxOdd = Math.max(maxOdd, value);
            } else {
                minEven = Math.min(minEven, value);
            }
        }

        return maxOdd - minEven;
    }
}
