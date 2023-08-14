package Java.problems;

public class RecursiveRange {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
     int result = recursiveRange(arr, arr.length - 1);
     System.out.println(result);
    }

    public static int recursiveRange(int[] arr, int n) {
        if(n == 0) return 0;

        return arr[n] + recursiveRange(arr, n-1);
    }
}
