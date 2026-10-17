package Java.leetcode.easy;

import java.util.Set;
import java.util.HashSet;

public class MissingNumber {

    public static void main(String[] args) {
        int[] nums = {3,0,1,2};
        System.out.println(missingNumber2(nums));
    }

    //USING HASHSET
    public static int missingNumber(int[] nums){

        Set<Integer> set = new HashSet<>();

        for(int num : nums){
            set.add(num);
        }

        int count = nums.length + 1;

        for(int i = 0 ; i < count ; i++){
            if(!set.contains(i)) return i;
        }

        return -1;
    }

    //USING SUM OF NUMBERS
    public static int missingNumber2(int[] nums){

        int length = nums.length;
        int expectedSum = (length * (length+1))/2;
        int actualSum = 0;
        
        for(int num : nums ) actualSum += num;

        return expectedSum - actualSum;
    }

    //USING CYCLE SORT
    public static int missingNumber3(int[] nums){
        int i = 0;
        while(i < nums.length) {
            int correctIndex = nums[i];
            if(nums[i] < nums.length && nums[i] != nums[correctIndex]) {
                swap(nums, i, correctIndex);
            } else {
                i++;
            }
        }

        for(i = 0; i < nums.length; i++) {
            if(nums[i] != i) {
                return i;
            }
        }

        return nums.length;
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
