package Java.leetcode.easy;

public class MaxOddBinaryNumber {
    public static void main(String[] args) {
        String s = "0101";
        System.out.println(maximumOddBinaryNumber(s));
    }

    public static String maximumOddBinaryNumber(String s) {

        StringBuilder str = new StringBuilder();

        int ones = 0, zeroes = 0;

        for(int i = 0 ; i < s.length() ; i++){
            if(s.charAt(i) == '1') ones++;
        }

        zeroes = s.length() - ones;

        for(int i = 0 ; i < ones - 1; i++){
            str.append("1");
        }

        for(int i = 0 ; i < zeroes ; i++){
            str.append("0");
        }

        str.append("1");

        return str.toString();
    }
}
