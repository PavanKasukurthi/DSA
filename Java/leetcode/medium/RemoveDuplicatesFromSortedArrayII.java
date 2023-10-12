package Java.leetcode.medium;

public class RemoveDuplicatesFromSortedArrayII {
    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,3};
        
        System.out.println(removeDuplicates(nums));
    }

    //TWO POINTERS
    public static int removeDuplicates(int[] nums){
        int index = 2;

        for(int i = 2 ; i < nums.length ; i++){
            if(nums[i] != nums[index-2]){
                nums[index] = nums[i];
                index++;
            }
        }

        return index;
    }
}
