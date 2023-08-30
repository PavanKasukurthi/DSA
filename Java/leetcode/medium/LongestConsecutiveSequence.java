package Java.leetcode.medium;

import java.util.HashSet;

public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        int[] nums = {100,4,200,1,3,2};
        System.out.println(longestConsecutiveSequence(nums));
        // longestConsecutiveSequence(nums);
    }

    public static int longestConsecutiveSequence(int[] nums){
        
        HashSet<Integer> set = new HashSet<>();

        for(int n : nums){
            set.add(n);
        }

        int max_sequence_length = 0;

        for(int n : nums){
            //IF NUMBER DOES NOT HAVE A PRECEDENT
            if(!set.contains(n-1)){
                int length = 0;
                //CHECK IF NUMBER + 1 IS PRESENT AND INCREMENT THE LENGTH RANGE
                while(set.contains(n+length)){
                    length++;
                }
                max_sequence_length = Math.max(length, max_sequence_length);
            }
        }

      return max_sequence_length;
    }
}
