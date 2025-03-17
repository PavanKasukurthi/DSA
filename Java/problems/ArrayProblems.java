package Java.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ArrayProblems {
    
    public static void main(String[] args) {
        int[] a = { 3, 9, 2, 3, 1, 7, 2, 3, 5 }; 
        int k = 3; 
        // System.out.println(Arrays.toString(removeAllOccurrencesOfAnElementInAnArray(a, k)));
        System.out.println(secondLargestElementInAnArray(a));
    }

    /* REMOVE ALL OCCURENCES OF AN ELEMENT IN AN ARRAY */
    public static int[] removeAllOccurrencesOfAnElementInAnArray(int[] arr, int n){
        int index = 0;
        for(int i = 0 ; i < arr.length ; i++){
            if(arr[i] != n){
                arr[index++] = arr[i];
            }
        }

        return Arrays.copyOf(arr, index);
    }


    /* SECOND LARGEST ELEMENT IN AN ARRAY WITHOUT SORTING */
    public static int secondLargestElementInAnArray(int[] arr){
        int max = Integer.MIN_VALUE;

        for(int i = 0 ; i < arr.length ; i++){
            if(arr[i] > max) max = arr[i];
        }

        int max2 = Integer.MIN_VALUE;
        for(int i = 0 ; i < arr.length ; i++){
            if(arr[i] > max2 && arr[i] != max){
                max2 = arr[i];
            }
        }

        return max2;
    }

    /* MAXIMUM NUMBER OF CONSECUTIVE 1s OR 0s */
    public static int maxConsecutiveCount(int[] arr){
        if(arr.length == 0) return 0;

        int maxCount = 0, count = 1;

        for(int i = 1 ; i < arr.length ; i++){
            if(arr[i] == arr[i-1]){
                count++;
            }
            else{
                maxCount = Math.max(maxCount, count);
                count = 1;
            }
        }
        return Math.max(maxCount, count);
    }

    /* ROTATE ARRAY */
    public static int[] rotateArray(int[] arr, int k){
        return arr;
    }

    /* REARRANGE POSITIVE AND NEGATIVE NUMBERS IN ALTERNATE FASHION */
    public static ArrayList<Integer> rearrange(ArrayList<Integer> arr){
        ArrayList<Integer> pos = new ArrayList<>();
        ArrayList<Integer> neg = new ArrayList<>();

        for(int i : arr){
            if(i < 0) neg.add(i);
            else pos.add(i);
        }

        int a = 0, b = 0, k = 0;
        while(a < pos.size() && b < neg.size()){
            if(k % 2 == 0) arr.set(k++, pos.get(a++));
            else arr.set(k++, neg.get(b++));
        }

        while(a < pos.size()) arr.set(k++, pos.get(a++));
        while(b < neg.size()) arr.set(k++, neg.get(b++));

        return arr;
    }

    /* REARRANGE POSITIVE AND NEGATIVE NUMBERS IN ALTERNATE FASHION USING JAVA STREAMS*/
    public static ArrayList<Integer> rearrangeStreams(ArrayList<Integer> arr){
        List<Integer> pos = arr.stream().filter(x -> x>=0).collect(Collectors.toList());
        List<Integer> neg = arr.stream().filter(x -> x<0).collect(Collectors.toList());

        ArrayList<Integer> result = new ArrayList<>();

        IntStream.range(0, Math.max(pos.size(), neg.size()))
        .forEach(i -> {
            if(i < pos.size()) result.add(pos.get(i));
            if(i < neg.size()) result.add(neg.get(i));
        });

        return result;
    }
}
