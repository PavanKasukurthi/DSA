package Java.algorithms.searching;

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
