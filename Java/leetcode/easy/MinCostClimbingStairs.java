package Java.leetcode.easy;

public class MinCostClimbingStairs{
    public static void main(String[] args) {
        int[] cost = {10,15,20};
        System.out.println(minCostClimbingStairs(cost));
    }

    public static int minCostClimbingStairs(int[] cost){
        int[] result = new int[cost.length + 1];

        for(int i = 2 ; i <= cost.length ; i++){
            result[i] = Math.min(cost[i-2], cost[i-1]);
        }
        return result[cost.length];
    }
}