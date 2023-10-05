package Java.leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MajorityElementII{
    public static void main(String[] args) {
        int[] nums = {3,2,3};
        System.out.println(majorityElementII(nums));
    }

    public static List<Integer> majorityElementII(int[] nums){
        List<Integer> list = new ArrayList<>();

        HashMap<Integer, Integer> frequency = new HashMap<>();

        for(int num : nums){
            frequency.merge(num, 1, Integer::sum);
        }

        for (Map.Entry<Integer, Integer> entry : frequency.entrySet()) {
            int element = entry.getKey();
            int count = entry.getValue();

            if(count > nums.length/3){
                list.add(element);
            }
        }
        return list;
    }
}