package Java.leetcode.easy;

import java.util.HashMap;

public class CountElementsWithMaxFreq{
    public static void main(String[] args) {
        int[] nums = {1,2,2,3,1,4};
        System.out.println(maxFrequencyElements(nums));
    }

    public static int maxFrequencyElements(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int n : nums){
            map.merge(n, 1, Integer::sum);
        }

        int max = Integer.MIN_VALUE;

        for(int value : map.values()){
            max = Math.max(max, value);
        }

        int result = 0;

        for(int value : map.values()){
            if(value == max) result += value;
        }

        return result;
    }
}