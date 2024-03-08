package Java.leetcode.easy;

import java.util.HashSet;

public class ContainsDuplicate {
    public static boolean containsDuplicate(int[] a) {
        HashSet<Integer> set = new HashSet<>();

        for(int n : a){
            if(set.contains(n)){
                return true;
            }
            set.add(n);
        }

        return false;
    }
}
