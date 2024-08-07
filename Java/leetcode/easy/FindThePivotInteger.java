package Java.leetcode.easy;

public class FindThePivotInteger {
    public static void main(String[] args) {
        System.out.println(pivotIntegerBinary(8));
    }

    //MATHEMATICAL APPROACH
    public static int pivotInteger(int n){
        if(n == 1) return 1;
        int sum = n*(n+1)/2;
        int pivot = (int)Math.sqrt(sum);
        return pivot*pivot == sum ? pivot : -1;
    }

    //BINARY SEARCH APPROACH
    public static int pivotIntegerBinary(int n){
        if(n == 1) return 1;
        int left = 0, right = n;
        while(left <= right){
            int mid = left - (left - right)/2;
            int sum = n*(n+1)/2;
            int first = mid*(mid + 1)/2;
            int second = sum - first + mid;
            if(first == second) return mid;
            if(first > second) right = mid - 1;
            else left = mid + 1;
        }
        return -1;
    }
}
