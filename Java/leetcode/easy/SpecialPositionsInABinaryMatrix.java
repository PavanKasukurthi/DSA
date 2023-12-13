package Java.leetcode.easy;

public class SpecialPositionsInABinaryMatrix {
     public int numSpecial(int[][] mat) {
        int specialPositions = 0;
        int rows = mat.length;
        int cols = mat[0].length;
        int[] rowSum = new int[rows];
        int[] colSum = new int[cols];

        for(int i = 0 ; i < rows ; i++){
            for(int j = 0 ; j < cols ; j++){
                if(mat[i][j] == 1){
                    rowSum[i]++;
                    colSum[j]++;
                }
            }
        } 

        for(int i = 0 ; i < rows ; i++){
            for(int j = 0 ; j < cols ; j++){
                if(mat[i][j] == 1 && rowSum[i] == 1 && colSum[j] == 1) specialPositions++;
            }
        }

        return specialPositions;
     }
}
