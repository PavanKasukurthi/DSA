package Java.leetcode.easy;

import java.util.Arrays;

public class LargestPositiveIntegerThatExistsWithNegative {
    public static void main(String[] args) {
        int[] nums = {-1,2,-3,3};
        System.out.println(findMaxK(nums));
    }

    public static int findMaxK(int[] nums){
        Arrays.sort(nums);

        int left = 0, right = nums.length - 1;
        int maxK = Integer.MIN_VALUE;

        while(left < right){
            int sum = nums[left] + nums[right];
            if(sum == 0){
                maxK = Math.max(maxK , nums[right]);
                left++;
                right--;
            }
            else if(sum < 0) left++;
            else right --;
        }

        return maxK != Integer.MIN_VALUE ? maxK : -1;
    }
}
