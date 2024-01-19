package Java.leetcode.medium;

public class MinimumFallingPathSum {

    public static void main(String[] args) {
        int[][] matrix =  {{2,1,3},{6,5,4},{7,8,9}};
        System.out.println(minFallingPathSum(matrix));
    }

     public static int minFallingPathSum(int[][] matrix) {
        
        int n = matrix.length;
        int[][] dp = new int[n][n];

        for(int i = 0 ; i < n ; i++) dp[0][i] = matrix[0][i];

        for(int i = 1 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                int min = Integer.MAX_VALUE;
                if(i-1 >= 0) min = Math.min(min , dp[i-1][j]);
                if(i-1 >= 0 && j-1 >=0 ) min = Math.min(min, dp[i-1][j-1]);
                if(i-1 >= 0 && j+1 < n) min = Math.min(min, dp[i-1][j+1]);

                dp[i][j] = min + matrix[i][j];
            }
        }

        int ans = dp[n-1][0];

        for(int i = 0 ; i < n ; i++){
            ans = Math.min(ans, dp[n-1][i]);
        }

        return ans;
    }
}
