package Java.leetcode.easy;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.stream.IntStream;

public class RemoveDuplicatesFromSortedArray {
    public static void main(String[] args) {
        int[] nums = { 0, 0, 1, 1, 1, 2, 2, 3, 3, 4 };
        System.out.println(removeDuplicates(nums));
    }

    // USING SET
    public static int removeDuplicatesSet(int[] nums) {
        LinkedHashSet<Integer> result = new LinkedHashSet<>();

        for (int i = 0; i < nums.length; i++) {
            result.add(nums[i]);
        }

        int i = 0;
        for (int o : result) {
            nums[i++] = o;
        }

        System.out.println(Arrays.toString(nums));

        return result.size();
    }

    // TWO POINTERS
    public static int removeDuplicates(int[] nums) {
        int j = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[j] = nums[i];
                j++;
                System.out.println(i + " " + j);
            }
        }
        System.out.println(Arrays.toString(nums));
        return j;
    }

    // USING JAVA STREAMS
    public static int removeDuplicatesUsingStreams(int[] nums) {
        // return (int) IntStream.of(nums).distinct().count();
        return (int) Arrays.stream(nums).distinct().count();

        // IF WHOLE ARRAY IS TO BE RETURNED
        // List<Integer> result =
        // Arrays.stream(nums).distinct().collect(Collectors.toList());
    }
}
