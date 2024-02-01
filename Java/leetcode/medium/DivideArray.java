package Java.leetcode.medium;

import java.util.Arrays;

public class DivideArray{
    public static void main(String[] args) {
        
    }

    public static int[][] divideArray(int[] nums, int k){

        if(nums.length % 3 != 0) return new int[0][0];

        Arrays.sort(nums);

        int[][] result = new int[nums.length/3][];
        int j = 0;

        for(int i = 0 ; i < nums.length ; i+=3){
            if(i+2 < nums.length && nums[i+2] - nums[i] <= k){
                int[] triplet = {nums[i], nums[i+1], nums[i+2]};
                result[j++] = triplet;
            }
            else{
                return new int[0][0];
            }
        }

        return result;
    }
}