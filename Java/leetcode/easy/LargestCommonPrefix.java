package Java.leetcode.easy;

import java.util.Arrays;

public class LargestCommonPrefix{
    public static void main(String[] args) {
        String[] strs = {"flower", "flow", "flip"};
        System.out.println(largestCommonPrefix(strs));
    }
    public static String largestCommonPrefix(String[] strs){

        Arrays.sort(strs);
        int count = 0;
        String start = strs[0];
        String end = strs[strs.length - 1];

        for(int i = 0 ; i < strs.length ; i++){
            if(start.charAt(count) == end.charAt(count)){
                count++;
            }
        }

        return start.substring(0, count);
    }
}