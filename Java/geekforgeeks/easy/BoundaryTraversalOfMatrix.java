package Java.geekforgeeks.easy;

import java.util.ArrayList;

public class BoundaryTraversalOfMatrix {

    public static void main(String[] args) {
        int[][] matrix = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12},
            {13, 14, 15,16}
        };

        System.out.println(boundaryTraversal(matrix, 4, 4));
    }
    
    //Function to return list of integers that form the boundary 
    //traversal of the matrix in a clockwise manner.
    static ArrayList<Integer> boundaryTraversal(int matrix[][], int r, int c)
    {
        // code here 
        ArrayList<Integer> ans = new ArrayList<>();

        if(r == 1) for(int i = 0 ; i < c ; i++) ans.add(matrix[0][i]);
          
        else if(c == 1) for(int i = 0 ; i < r ; i++) ans.add(matrix[i][0]);
              
          
        else{
                
            for(int i = 0 ; i < c-1 ; i++) ans.add(matrix[0][i]);
                
        
            for(int i = 0 ; i < r - 1 ; i++) ans.add(matrix[i][c-1]);
                
        
            for(int i = c-1 ; i>0 ; i--) ans.add(matrix[r-1][i]);
                
        
            for(int i = r-1 ; i>0 ; i--) ans.add(matrix[i][0]);
        

        }

        return ans;
    }
}
