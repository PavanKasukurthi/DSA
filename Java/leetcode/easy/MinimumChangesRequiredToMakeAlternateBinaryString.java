package Java.leetcode.easy;

public class MinimumChangesRequiredToMakeAlternateBinaryString {
    public static void main(String[] args) {
        System.out.println(minOperations("01"));
    }

    public static int minOperations(String s){

        int start0 = 0;
        int start1 = 0;

        for(int i = 0 ; i < s.length() ; i++){
            if(i % 2 == 0){ //even indices
                if(s.charAt(i) == '0'){
                    start1++;
                }
                else{
                    start0++;
                }
            }
            else{ //odd indices
                if(s.charAt(i) == '1'){
                    start1++;
                }
                else {
                    start0++;
                }
            }
        }

        return Math.min(start0, start1);
    }
}
