package Java.leetcode.medium;

import java.util.Arrays;

public class FindFirstAndLastIndex {
    public static void main(String[] args) {
        int[] nums = {5,7,7,8,8,10};
        int target = 4;
        System.out.println(Arrays.toString(searchRange(nums, target)));
    }

    //USING BINARY SEARCH
    public static int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        result[0] = startingIndex(nums, target);
        result[1] = endingIndex(nums, target);

        return result;
    }

    public static int startingIndex(int[] nums, int target){
        int index = -1;
        int start = 0;
        int end = nums.length - 1;
        while(start <= end){
            int mid = start + (end - start)/2;
            if(nums[mid] == target) index = mid;
            if(nums[mid] >= target) end = mid - 1;
            else start = mid + 1;
        }
        return index;
    }

    public static int endingIndex(int[] nums, int target){
        int index = -1;
        int start = 0;
        int end = nums.length - 1;
        while(start <= end){
            int mid = start + (end - start)/2;
            if(nums[mid] == target) index = mid;
            if(nums[mid] <= target) start = mid + 1;
            else end = mid - 1;
        }
        return index;
    }
}