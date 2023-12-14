package Java.leetcode.medium;

public class DifferenceBetweenOnesAndZeroesInRowAndColumn {
     public int[][] onesMinusZeros(int[][] grid) {
        int rows = grid.length;
	    int cols = grid[0].length;
	    
        int[][] diff = new int[rows][cols];
        
        int[] onesRow = new int[rows];
        int[] onesCol = new int[cols];
        int[] zeroesRow = new int[rows];
        int[] zeroesCol = new int[cols];
        
        //ONES ROW
        for(int i = 0 ; i < rows ; i++){
            for(int j = 0 ; j < cols ; j++){
                onesRow[i] += grid[i][j];
            }
        }
        
        //ONES COL
        for(int j = 0 ; j < cols ; j++){
            for(int i = 0 ; i < rows ; i++){
                onesCol[j] += grid[i][j];
            }
        }
        
        //ZEROES ROW
        for(int i = 0 ; i < rows ; i++){
            zeroesRow[i] = rows - onesRow[i];
        }
        

        //ZEROES COL
        for(int j = 0 ; j < cols ; j++){
            zeroesCol[j] = cols - onesCol[j]; 
        }
        
        //DIFF MATRIX
        for(int i = 0 ; i < rows ; i++){
            for(int j = 0 ; j < cols ; j++){
                diff[i][j] = onesRow[i] + onesCol[j] - zeroesRow[i] - zeroesCol[j];
            }
        }

        return diff;
    }    
}
