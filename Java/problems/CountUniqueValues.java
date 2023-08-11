package Java.problems;

public class CountUniqueValues {
    public static void main(String[] args){
        int[] arr = {1,2,3,4,4,4,5,6,9, 11,11 ,12};
        int[] empty = {};
        System.out.println(countUniqueValues(arr));
        System.out.println(countUniqueValues(empty));
    }

    public static int countUniqueValues(int[] arr){
        int i = 0;

        if(arr.length == 0) return 0;

        for(int j = 0 ; j < arr.length ; j++){
            if(arr[j] != arr[i]){
                i++;
                arr[i] = arr[j];
            }
        }

        return i+1;
    }
}
