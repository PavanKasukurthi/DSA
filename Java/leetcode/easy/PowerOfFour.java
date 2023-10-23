package Java.leetcode.easy;

public class PowerOfFour{

    public static boolean powerOfFour(int n ){
        if(n == 0 ) return false;

        while(n % 4 == 0){
            n /= 4;
        }

        return n == 1;
    }
}