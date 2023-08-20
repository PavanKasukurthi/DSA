package Java.leetcode.easy;

/* Given an integer array nums and an integer val, remove all occurrences of val in nums in-place. The order of the elements may be changed. Then return the number of elements in nums which are not equal to val.
Consider the number of elements in nums which are not equal to val be k, to get accepted, you need to do */

public class RemoveElement {
    public static void main(String[] args) {
        int[] arr = {3,2,2,3};
        int val = 3;
        System.out.println(removeElement(arr, val));
    }

    public static int removeElement(int[] arr, int val){
        int count = 0;
        for(int num: arr){
            if(num != val){
                arr[count] = num;
                count++;
            }
        }
        return count;
    }
}