package Java.leetcode.easy;

public class LargestOddNumberInAString {
    public static void main(String[] args) {
        String num = "62422";
        System.out.println(largestOddNumber(num));
    }

    public static String largestOddNumber(String num) {
        
        while(num.length() != 0){
            int lastDigit = (int)num.charAt(num.length() - 1);
            if(lastDigit % 2 != 0){
                return num.substring(0, num.length());
            }
            else num = num.substring(0, num.length() - 1);
        }

        return "";
    }
}
