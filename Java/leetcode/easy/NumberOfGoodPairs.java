package Java.leetcode.easy;

import java.util.HashMap;

public class NumberOfGoodPairs {
    public static void main(String[] args) {
        int[] nums = {1,2,3,1,1,3};
        System.out.println(numberOfGoodPairs2(nums));
    }

    //BRUTE FORCE
    public static int numberOfGoodPairs(int[] nums){
        int count = 0;

        for(int i = 0 ; i < nums.length ; i++){
            for(int j = i+1 ; j < nums.length ; j++){
                if(nums[i] == nums[j]) count++;
            }
        }
        return count;
    }

    //USING HASHMAP
    public static int numberOfGoodPairs2(int[] nums){
        int count = 0;

        HashMap<Integer, Integer> numCount = new HashMap<>();

        for(int num : nums){
            if(numCount.containsKey(num)){
                count += numCount.get(num);
                numCount.put(num, numCount.get(num) + 1);
            }
            else{
                numCount.put(num,1);
            }
        }

        return count;
    }
}
