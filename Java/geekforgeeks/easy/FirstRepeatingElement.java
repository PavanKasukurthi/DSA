package Java.geekforgeeks.easy;

import java.util.HashSet;

public class FirstRepeatingElement {
    public static void main(String[] args) {
        int arr[] = {1, 5, 3, 4, 3, 5, 6};
        System.out.println(firstRepeated(arr, 7));
    }

    public static int firstRepeated(int[] arr, int n){

        HashSet<Integer> set = new HashSet<>();

        for(int i : arr){
            if(set.contains(i)){
                return i;
            }
            else set.add(i);
        }

        return -1;
    }
}
