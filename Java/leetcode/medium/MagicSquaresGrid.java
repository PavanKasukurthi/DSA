package Java.leetcode.medium;

public class MagicSquaresGrid{
    public static void main(String[] args){
        int[][] grid = {{4,3,8,4},{9,5,1,9},{2,7,6,2}};
        //edge case
        int[][] gridEdgeCase = {{5,5,5,5},{5,5,5,5},{5,5,5,5}};

        System.out.println(numMagicSquaresInside(gridEdgeCase));
    }
    
    public static int numMagicSquaresInside(int[][] grid) {
        int count = 0;
        for(int i = 0; i <= grid.length - 3 ; i++){
            for(int j = 0; j <= grid[0].length - 3 ; j++){
                if(isMagicSquare(grid, i, j)){
                    count++;
                }
            }
        }
        return count;
    }

    public static boolean isMagicSquare(int[][] grid, int i, int j){
        boolean[] seen = new boolean[10];
        for(int x = 0 ; x < 3 ; x++){
            for(int y = 0 ; y < 3 ; y++){
                int num = grid[i+x][j+y];
                if(num < 1 || num > 9 || seen[num]) return false;
                seen[num] = true;
            }
        }

        //initial row sum
        int sum = grid[i][j] + grid[i][j+1] + grid[i][j+2];

        //Checking row sum
        for(int x = 0 ; x < 3 ; x++){
            if(sum != grid[i+x][j] + grid[i+x][j+1] + grid[i+x][j+2]) return false;
        }

        //Checking column sum
        for(int y = 0 ; y < 3 ; y++){
            if(sum != grid[i][j+y] + grid[i+1][j+y] + grid[i+2][j+y]) return false;
        }

        //Checking primary diagonal sum
        if(sum != grid[i][j] + grid[i+1][j+1] + grid[i+2][j+2]) return false;

        //Checking secondary diagonal sum
        if(sum != grid[i+2][j] + grid[i+1][j+1] + grid[i][j+2]) return false;

        return true;
    }
}