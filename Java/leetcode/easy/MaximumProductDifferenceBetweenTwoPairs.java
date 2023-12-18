package Java.leetcode.easy;

import java.util.Arrays;

public class MaximumProductDifferenceBetweenTwoPairs {
    
    //USING SORTING
    public int maxProductDifference(int[] nums) {
        Arrays.sort(nums);

        return (nums[nums.length - 1] * nums[nums.length - 2]) - (nums[0] * nums[1]);
    }

    //O(n) complexity
    public int maxProductDifference2(int[] nums){
        int max1 = 0;
       int max2 = 0;
       int min1 = Integer.MAX_VALUE;
       int min2 = Integer.MAX_VALUE;

       for(int num : nums){
           if(num > max1){
               max2 = max1;
               max1 = num;
           }
           else max2 = Math.max(max2, num);

           if(num < min1){
               min2 = min1;
               min1 = num;
           }
           else min2 = Math.min(min2, num);
       }

       return (max2 * max1) - (min2 * min1);
    }
}
