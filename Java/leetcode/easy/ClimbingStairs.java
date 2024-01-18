package Java.leetcode.easy;

public class ClimbingStairs {
    public int climbStairs(int n){
        if( n < 3) return n;

        int[] fs = new int[n+1];

        fs[1] = 1;
        fs[2] = 2;

        for(int i = 3; i <= n ; i++){
            fs[i] = fs[i-1] + fs[i-2];
        }

        return fs[n];
    }
}
