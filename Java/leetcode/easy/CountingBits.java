package Java.leetcode.easy;

import java.util.Arrays;

public class CountingBits{
    public static void main(String[] args) {
        System.out.println(Arrays.toString(countingBits(5)));
    }

    //BRUTE FORCE
    public static int[] countBits(int n) {
       int[] ans = new int[n+1];
    
       for(int i = 0 ; i <= n ; i++) {
    	   ans[i] = Bits(i);
       }
       
       return ans;
    }
    
    private static int Bits(int i) {
    	int count = 0;
		while (i != 0) {
			if((i&1) == 1) {
				count++;
			}
			i>>=1;
		}
		return count;
	}

    //OPTIMIZED 
    public static int[] countingBits(int num){
        int[] result = new int[num+1];

        result[0] = 0;

        for(int i = 1 ; i <= num ; i++){
            result[i] = result[i/2] + i%2;
        }

        return result;
    }
}