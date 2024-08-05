package Java.leetcode.easy;

import java.util.Arrays;
import java.util.HashMap;

public class MakeTwoArraysEqualByReversingSubArrays {
    public static void main(String[] args) {
        int[] target = {1,2,3,4};
        int[] arr = {2,4,1,3};
        System.out.println(canBeEqual2(target, arr));
    }

    //SORTING THE ARRAYS
    public static boolean canBeEqual(int[] target, int[] arr) {
        
        if(target.length != arr.length) return false;

        Arrays.sort(target);
        Arrays.sort(arr);

        int i = 0, j = 0;
        while(i < target.length){
            if(target[i] != arr[j]) return false;
            i++;
            j++;
        }

        return true;
    }
    
    //UNIQUE ELEMENT TRACKING
    public static boolean canBeEqual2(int[] target, int[] arr){
        int[] elementCounts = new int[1001];
        int uniqueCount = 0;

        for(int i = 0 ; i < target.length ; i++){
            if(elementCounts[target[i]]++ == 0) uniqueCount++;
            if(elementCounts[arr[i]]-- == 1) uniqueCount--;
        }

        return uniqueCount == 0;
    }

    //USING HASHMAP
    public static boolean canBeEqual3(int[] target, int[] arr){

        HashMap<Integer, Integer> freqCounter1 = new HashMap<>();
        HashMap<Integer, Integer> freqCounter2 = new HashMap<>();

        for(int i : target) freqCounter1.merge(i, 1, Integer::sum);
        for(int i : arr) freqCounter2.merge(i, 1, Integer::sum);

        return freqCounter1.equals(freqCounter2) ? true : false;
    }
}
