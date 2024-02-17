package Java.leetcode.medium;

import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;

public class LeastNumberOfUniqueDigitsAfterKRemovals{
    public static int findLeastNumOfUniqueInts(int[] arr, int k) {
        
        HashMap<Integer, Integer> freq = new HashMap<>();

        for(int n : arr){
            freq.merge(n, 1, Integer::sum);
        }

        List<Map.Entry<Integer, Integer>> elements = new ArrayList<>();

        elements.sort((a,b) -> a.getValue() - b.getValue());

        for(Map.Entry<Integer, Integer> map : elements){
            if(map.getValue() <= k){
                k = k - map.getValue();
                freq.remove(map.getKey());
            }
            else break;
        }

        return freq.size();
    }
}