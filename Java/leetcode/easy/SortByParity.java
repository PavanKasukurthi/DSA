package Java.leetcode.easy;

import java.util.Arrays;

public class SortByParity {
    public static void main(String[] args) {
        int[] nums = {3,1,2,4};
        System.out.println(Arrays.toString(sortByParity(nums)));
    }

    public static int[] sortByParity(int[] nums){

        int j = 0;
        for(int i = 0 ; i < nums.length ; i++){
            if(nums[i] % 2 == 0){
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                j++;
            }
        }
        return nums;
    }
}
