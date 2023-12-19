package Java.leetcode.easy;

import java.util.Arrays;

public class MoveZeroes {

    public static void main(String[] args) {
        int[] nums = {0,1,0,3,12};
        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void moveZeroes(int[] nums){
        if(nums.length == 1) return;

        int j = 0;
        for(int i = 0 ; i < nums.length ; i++){
            if(nums[i] != 0){
                nums[j++] = nums[i];
            }
        }

        while(j < nums.length){
            nums[j++] = 0;
        }
    }
}
