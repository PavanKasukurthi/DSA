package Java.leetcode.easy;

import java.util.Arrays;

public class AssignCookies {
    public int findContentChildren(int[] g, int[] s) {

       if(s.length == 0) return 0;

       Arrays.sort(g);
       Arrays.sort(s);

       int count = 0;

       int cookieIndex = s.length - 1;
       int childIndex = g.length - 1;

       while(cookieIndex >= 0 && childIndex >= 0){
           if(s[cookieIndex] >= g[childIndex]){
               count++;
               cookieIndex--;
               childIndex--;
           }
           else{
               childIndex--;
           }
       }

       return count;
    }
}
