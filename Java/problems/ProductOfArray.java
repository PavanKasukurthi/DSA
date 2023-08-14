package Java.problems;

public class ProductOfArray {
    
    public static void main(String[] args) {
        int[] arr = {1,2,3,4};
        int result = productOfArray(arr, arr.length - 1);
        if(result == 0){
            System.out.println("Empty Array is entered");
        }
        System.out.println(result);
    }

    public static int productOfArray(int[] arr, int n) {

        if(n == 0) return 0;
        return arr[n] * productOfArray(arr, n-1);
    }
}
