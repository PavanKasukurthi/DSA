package Java.leetcode.medium;

import java.util.List;
import java.util.ArrayList;

public class RearrangeArrayElementsBySign {
    public static void main(String[] args) {
        
    }

     public static int[] rearrangeArray(int[] nums) {
        
        List<Integer> neg = new ArrayList<>();
        List<Integer> pos = new ArrayList<>();

        int[] result = new int[nums.length];

        for(int num : nums){
            if(num < 0) neg.add(num);
            else if(num > 0) pos.add(num);
        }

        int p = 0, n = 0;

        for(int i = 0 ; i < nums.length ; i+=2){
            result[i] = pos.get(p++);
        }

        for(int i = 1 ; i < nums.length ; i+=2){
            result[i] = neg.get(n++);
        }

        return result;
    }
}
