package Java.leetcode.medium;

import java.util.HashMap;

public class MinimumNumberOfOperationsToMakeArrayEmpty{
    public int minOperations(int[] nums) {
        HashMap<Integer, Integer> freq = new HashMap<>();

        int count = 0;

        for(int n : nums){
            freq.merge(n, 1, Integer::sum);
        }

        for(int value : freq.values()){
            if(value == 1) return -1;

            count += Math.ceil((double)value/3);
        }

        return count;
    }
}