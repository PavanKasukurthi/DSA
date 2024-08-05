package Java.leetcode.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class SortArrayByIncreasingFrequency {
    public static void main(String[] args) {
        int[] nums = {1,1,2,2,2,3};
        System.out.println(Arrays.toString(frequencySort(nums)));
    }

    public static int[] frequencySort(int[] nums) {
        
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i : nums){
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        List<Integer> list = Arrays.stream(nums).boxed().collect(Collectors.toList());

        list.sort((a,b) -> {
            int freqCompare = map.get(a).compareTo(map.get(b));
            if(freqCompare == 0) return b.compareTo(a);
            else return freqCompare;
        });

        return list.stream().mapToInt(i -> i).toArray();
    }
}
