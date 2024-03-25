package Java.leetcode.medium;

import java.util.*;

public class FindAllDuplicatesInArray {
    public static void main(String[] args) {
        int[] nums = {4,3,2,7,8,2,3,1};
        System.out.println(findDuplicates(nums));
    }

    public static List<Integer> findDuplicates(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();
        List<Integer> list = new ArrayList<>();

        for(int n : nums){
            freq.merge(n, 1, Integer::sum);
        }

        for(Map.Entry<Integer,Integer> entry : freq.entrySet()){
            if(entry.getValue() > 1) list.add(entry.getKey());
        }

        return list;
    }
}
