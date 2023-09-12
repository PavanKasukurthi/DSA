package Java.leetcode.easy;

public class SmallestEvenMultiple {
    public static void main(String[] args) {
        System.out.println(smallestEvenMultiple(7));
    }
    public static int smallestEvenMultiple(int n){
        if(n%2 == 0) return n;

        return 2 * n;
    }
}
