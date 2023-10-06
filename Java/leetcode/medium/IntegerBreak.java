package Java.leetcode.medium;

public class IntegerBreak {
    public static void main(String[] args) {
        System.out.println(integerBreak(10));
    }

    //MATHEMATICAL APPROACH
    public static int integerBreak(int n){
        if(n <= 3) return n-1;

        int ans = 1;

        while(n > 4){
            ans *= 3;
            n -= 3;
        }

        return ans*n;
    }
}
