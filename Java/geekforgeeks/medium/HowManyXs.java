package Java.geekforgeeks.medium;

public class HowManyXs {
    public static void main(String[] args) {
        System.out.println(countX(18, 81, 9));
    }

    public static int countX(int L, int R, int X) {
        // code here
        int count = 0;
        for(int i = L+1 ; i < R ; i++){
            int j = i;
            while(j!=0){
                if( j % 10 == X) count++;
                j = j/10;
            }
        }
        return count;
    }
}
