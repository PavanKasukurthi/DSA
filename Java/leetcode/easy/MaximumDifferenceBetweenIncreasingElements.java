package Java.leetcode.easy;

// Leetcode 2016. Maximum Difference Between Increasing Elements

public class MaximumDifferenceBetweenIncreasingElements {
    public static void main(String[] args) {
        // int[] nums = { 7, 1, 5, 4 };
        int[] nums = { 9, 4, 9, 10 };
        System.out.println(maximumDifference(nums));
    }

    public static int maximumDifference(int[] nums) {
        int maxDifference = -1, premin = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > premin) {
                maxDifference = Math.max(maxDifference, nums[i] - premin);
            } else {
                premin = nums[i];
            }
        }

        return maxDifference;
    }
}