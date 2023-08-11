//Write a function called averagePair. Given a sorted array of integers and a target average,
// determine if there is a pair of values in the array where the average of the pair equals the target avg.
//There may be more than one pair that matches the average target

package Java.problems;

public class AveragePair {
    public static void main(String[] args) {
        int[] a = {1,2,3};
        int[] b = {1, 3, 3, 5, 6, 7, 10, 12, 19};
        int[] c = {};
        System.out.println(averagePair(a, 2.5));
        System.out.println(averagePair(b, 8));
        System.out.println(averagePair(c, 4));
    }

    public static boolean averagePair(int[] arr, double average){

        if(arr.length == 0) return false;

        int start = 0;
        int end = arr.length - 1;

        while(start <= end){
            double calc = ( arr[start] + arr[end] )/2.0;
            if(calc == average) return true;
            else if(calc > average) end -= 1;
            else if(calc < average) start += 1;
        }

        return false;
    }
}