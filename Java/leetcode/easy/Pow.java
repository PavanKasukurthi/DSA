package Java.leetcode.easy;

public class Pow {
    public static void main(String[] args) {
        System.out.println(myPow(2.1000, 3));
    }

    public static double myPow(double x, int n){
        if(n == 0) return 1;
		
		long N = n;
		
		if(N < 0) {
			N = -N;
			x = 1/x;
		}
		
		else if (N % 2 == 0) {
            return myPow(x * x, (int) (N / 2));
        } 
        
		return x * myPow(x, (int)(N - 1));
    }
}
