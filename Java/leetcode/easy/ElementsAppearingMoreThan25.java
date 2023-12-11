package Java.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

public class ElementsAppearingMoreThan25 {

    //USING HASHMAP
    public int findSpecialInteger(int[] arr) {
        double freq = 0.25 * arr.length;

        HashMap<Integer, Integer> freqCounter = new HashMap<>();

        for(Integer i : arr){
            freqCounter.merge(i, 1, Integer::sum);
        }

        for(Map.Entry<Integer, Integer> m : freqCounter.entrySet()){
            if(m.getValue() > freq){
                return m.getKey();
            }
        }

        return 0;
    }

}