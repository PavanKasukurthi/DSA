package Java.algorithms.searching;
public class BinarySearch {

    public static void main(String[] args) {
        int[] arr = {2,3,5,7,9,12,15};
        int target = 4;
//        int result = search(arr, target);
        int result = recursiveSearch(arr, target,0 , arr.length-1);
        if(result == -1) System.out.println("Number is not found in the array");
        else System.out.println("Number is present at " + result + " index" );
    }
    public static int search(int[] arr, int target){
        int start = 0;
        int end = arr.length - 1;
        while (start <= end){
            int mid = start + ((end - start)/2);

            if(arr[mid] == target){
                return mid;
            }

            if(arr[mid] > target){
                end = mid-1;
            }
            else start = mid+1;
        }

        return -1;
    }

    //Using recursion
    public static int recursiveSearch(int[] arr, int target, int start, int end){

        if(start <= end){
            int mid = start + ((end - start)/2);

            if(arr[mid] == target){
                return mid;
            }

            if(arr[mid] > target){
                return recursiveSearch(arr, target, start, mid-1);
            }
            else return recursiveSearch(arr, target, mid+1, end);
        }

        return -1;
    }
}

