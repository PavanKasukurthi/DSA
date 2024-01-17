package Java.leetcode.easy;

import java.util.HashMap;
import java.util.HashSet;

public class UniqueNumberOfOccurences {

    public boolean uniqueOccurences(int[] arr){

        HashMap<Integer, Integer> map = new HashMap<>();
        HashSet<Integer> set = new HashSet<>();

        for(int n : arr){
            map.merge(n, 1, Integer::sum);
        }

        for(int n : map.values()){
            set.add(n);
        }

        if(set.size() != map.size()) return false;

        return true;
    }


}
