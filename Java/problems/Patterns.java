package Java.problems;

public class Patterns {

    public static void main(String[] args) {
        pattern4(5);
    }
    
    /*PATTERN1
     * 
     * *
     * * *
     * * * *
     * * * * *
     */
    public static void pattern1(int n){
        for(int row = 1 ; row <= n ; row++){
            for(int col = 1 ; col <= row ; col++){
                System.out.print("*" + " ");
            }
            System.out.println();
        }
    }

    /* PATTERN2
    * * * * * 
    * * * * *
    * * * * *
    * * * * *
    * * * * *
     */

    public static void pattern2(int n){
        for(int row = 1 ; row <= n ; row++){
            for(int col = 1 ; col <= n ; col++){
                System.out.print("*" + " ");
            }
            System.out.println();
        }
    }

    /* PATTERN3
    * * * * * 
    * * * *
    * * *
    * *
    *
     */

    public static void pattern3(int n){
        for(int row = 1; row <=n ; row++){
            for(int col = n ; col>=row ; col--){
                System.out.print("*" + " ");
            }
            System.out.println();
        }
    }

    /* PATTERN 4
    1 
    1 2
    1 2 3
    1 2 3 4
    1 2 3 4 5
     */
    public static void pattern4(int n){
        int count = 1;
        for(int row = 1 ; row <= n ; row++){
            for(int col = 1 ; col <= row ; col++){
                System.out.print(count++ + " ");
            }
            count = 1;
            System.out.println();
        }
    }
}
