package Java.leetcode.easy;

import java.util.List;
import java.util.ArrayList;

public class GreatestNumberOfCandies {
    public static void main(String[] args) {
        int[] candies = {2,3,5,1,3};
        int extraCandies = 3;
        System.out.println(kidsWithCandies(candies, extraCandies));
    }
    public static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> list = new ArrayList<>();
        int max = Integer.MIN_VALUE;
        for(int c : candies){
            max = Math.max(max, c);
        }

        for(int c : candies){
            if(c + extraCandies >= max){
                list.add(true);
            }else{
                list.add(false);
            }
        }
        return list;
    }
}
