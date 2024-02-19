package Java.leetcode.easy;

public class PowerOfTwo {
     public boolean isPowerOfTwo(int n) {
        if(n == 0 || n == Integer.MIN_VALUE) return false;

        return n > 0 && (n & (n-1)) == 0;
    }
}
