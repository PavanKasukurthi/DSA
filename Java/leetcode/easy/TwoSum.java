package Java.leetcode.easy;

import java.util.Arrays;

public class TwoSum {
    public static void main(String[] args) {
        int[] arr = {3,2,4};
        System.out.println(Arrays.toString(twoSum(arr,6)));
    }
    
    //BRUTE FORCE
    public static int[] twoSumBrute(int[] nums, int target){
        int[] res = new int[2];
         for(int i = 0 ; i < nums.length-1; i++){
            for(int j = i+1 ; j < nums.length; j++){
                if(nums[i] + nums[j] == target){
                    res[0] = i;
                    res[1] = j;
                    break;
                }
            }
        }
        return res;
    }

    //TWO POINTER 
    public static int[] twoSum(int[] nums, int target){
        int[] sortedNums = Arrays.copyOf(nums, nums.length);
        Arrays.sort(sortedNums);
        
        int left = 0;
        int right = nums.length - 1;
        
        while (left < right) {
            int sum = sortedNums[left] + sortedNums[right];
            
            if (sum == target) {
                int firstIndex = -1;
                int secondIndex = -1;
                for (int i = 0; i < nums.length; i++) {
                    if (nums[i] == sortedNums[left] && firstIndex == -1) {
                        firstIndex = i;
                    } else if (nums[i] == sortedNums[right]) {
                        secondIndex = i;
                    }
                }
                return new int[] {firstIndex, secondIndex};
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        
        return new int[] {-1, -1}; 
    }
}
