package Java.leetcode.easy;

import java.util.*;
import java.util.stream.*;

// 1394. Find Lucky Integer in an Array

public class FindLuckyInteger {
    public static int findLuckyInteger(int[] nums) {

        return Arrays.stream(nums)
                .boxed()
                .collect(Collectors.groupingBy(c -> c,
                        Collectors.collectingAndThen(Collectors.counting(), Long::intValue)))
                .entrySet()
                .stream()
                .filter(e -> e.getKey() == e.getValue())
                .map(Map.Entry::getKey)
                .max(Integer::compareTo)
                .orElse(-1);
    }
}
