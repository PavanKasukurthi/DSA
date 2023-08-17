package Java.leetcode.easy;

public class PalindromeNumber {
    public static void main(String[] args) {
        System.out.println(palindromeNumber(45514));
    }

    public static boolean palindromeNumber(int num){

        int temp = num;
        int rev = 0;
        while(temp != 0){
            rev = rev*10 + temp%10;
            temp = temp/10;
        } 
        return (rev == num);
    }
}
