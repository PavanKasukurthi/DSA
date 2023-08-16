package Java.algorithms.searching;

//TIME COMPLEXITY: O(n) - as length of array increases time complexity increases
        // Best case: O(1)
        // Average: O(n)
        // Worst case: O(n)
//SPACE COMPLEXITY: O(1)

public class LinearSearch {
    public static void main(String[] args) {
        int[] arr = {2,4,12,3,1,7,5,8,9};

        System.out.println(linearSearch(arr, 3));
    }

    public static int linearSearch(int[] arr, int target){
        for(int i = 0 ; i < arr.length ; i++){
            if(arr[i] == target){
                return i;
            }
        }

        return -1;
    }
}
