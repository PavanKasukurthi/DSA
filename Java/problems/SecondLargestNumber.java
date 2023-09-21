package Java.problems;

public class SecondLargestNumber {
    public static void main(String[] args) {
        
    }

    public static int secondLargestNumber(int[] nums){
        int largest = Integer.MIN_VALUE;

        for(int num : nums){
            largest = Math.max(largest, num);
        }        

        int second = Integer.MIN_VALUE;

        for(int num : nums){
            if(num != largest){
                second = Math.max(second, num);
            }
        }

        if(second == Integer.MIN_VALUE) return -1;

        return second;
    }
}
