package Java.leetcode.easy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class FindAllNumbersDisappearedInArray {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int len = nums.length;
        ArrayList<Integer> result = new ArrayList<>();

        HashSet<Integer> set = new HashSet<>();

        for(int num : nums){
            set.add(num);
        }

        while(len > 0){
            if(!set.contains(len)) result.add(len);

            len--;
        }

        return result;
    }
}
