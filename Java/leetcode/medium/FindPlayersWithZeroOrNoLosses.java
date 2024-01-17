package Java.leetcode.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;

public class FindPlayersWithZeroOrNoLosses {
     public List<List<Integer>> findWinners(int[][] matches) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();  
        LinkedHashSet<Integer> set1 = new LinkedHashSet<>();
        LinkedHashSet<Integer> set2 = new LinkedHashSet<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0 ; i < matches.length ; i++){
            map.merge(matches[i][1], 1, Integer::sum);
        }

        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            if(entry.getValue() == 1) set2.add(entry.getKey());
        }

        for(int i = 0 ; i < matches.length ; i++){
            if(!map.containsKey(matches[i][0])){
                set1.add(matches[i][0]);
            }
        }

        ArrayList<Integer> ans1 = new ArrayList<>();
        ArrayList<Integer> ans2 = new ArrayList<>();

        for(int n : set1) ans1.add(n);
        for(int n : set2) ans2.add(n);

        Collections.sort(ans1);
        Collections.sort(ans2);

        ans.add(ans1);
        ans.add(ans2);

        return ans;
    }
}
