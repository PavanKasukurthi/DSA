package Java.leetcode.medium;

import java.util.Arrays;

public class RotateArray {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7};
        rotateArray(nums, 3);
        System.out.println(Arrays.toString(nums));
    }

    public static void rotateArray(int[] nums, int k){
        k = k % nums.length;
       reverse(nums, 0, nums.length -1 );
       reverse(nums, 0, k-1);
       reverse(nums, k, nums.length - 1);
    }

    public static void reverse(int[] nums, int left, int right){

        while(left < right){
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }
}
