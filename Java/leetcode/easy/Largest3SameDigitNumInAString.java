package Java.leetcode.easy;

public class Largest3SameDigitNumInAString {
    
    public static void main(String[] args) {
        String num = "6777133339";
        System.out.println(largestGoodInteger(num));
    }

    public static String largestGoodInteger(String num) {
        int res = 0;
        boolean flag = false;
        for(int i = 0 ; i < num.length()-2 ; i++){

            if(num.charAt(i) == num.charAt(i+1) && num.charAt(i) == num.charAt(i+2)){
                flag = true;
                res = Math.max(res, Integer.parseInt(num.substring(i, i+3)));
            }
        }

        if(res == 0 && flag == true) return "000";
        else if(flag == false) return "";

        return Integer.toString(res);
    }
}