package Java.problems;

public class KadanesAlgorithm {
    public static void main(String[] args) {
        int[] a = { -2, -3, 4, -1, -2, 1, 5, -3 };
        System.out.println(maxSubArraySum(a));
    }

    public static int maxSubArraySum(int[] arr){
        
        int maxSum = arr[0];
        int currSum = maxSum;

        for(int i = 1 ; i < arr.length ; i++){
            currSum = Math.max(arr[i], arr[i] + currSum);
            maxSum = Math.max(currSum, maxSum);
        }

        return maxSum;
    }
}
