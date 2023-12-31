package Java.leetcode.easy;

import java.util.Arrays;

public class MaxProductOfTwoElementsInArray {

    //WITHOUT SORTING
    public static int maxProduct(int[] nums) {
       int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;

        for (int num : nums) {
            if (num >= max1) {
                max2 = max1;
                max1 = num;
            } else if (num > max2) {
                max2 = num;
            }
        }

        return (max1 - 1) * (max2 - 1);
    }

    //USING SORTING
    public static int maxProduct2(int[] nums) {
        Arrays.sort(nums);

        return (nums[nums.length - 1] - 1) * (nums[nums.length - 2] - 1);
    }
}
