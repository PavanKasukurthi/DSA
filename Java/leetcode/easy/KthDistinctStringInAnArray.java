package Java.leetcode.easy;

import java.util.HashMap;

public class KthDistinctStringInAnArray {
    public static void main(String[] args) {
        String[] arr = {"d","b","c","b","c","a"};
        int k = 2;
        System.out.println(kthDistinct(arr, k));
    }

    public static String kthDistinct(String[] arr, int k) {
        HashMap<String, Integer> frequencyCounter = new HashMap<>();

        for(String s : arr){
            frequencyCounter.put(s, frequencyCounter.getOrDefault(s, 0) + 1);
        }

        for(String s : arr){
            if(frequencyCounter.get(s) == 1){
                --k;
                if(k == 0) return s;
            }
        }

        return "";
    }
}