package Java.problems;

public class Palindrome{
    public static void main(String[] args) {
        System.out.println(isPalindrome("hoojH"));
    }

    //MULTIPLE POINTERS
    public static boolean palindrome(String str){
        str = str.toLowerCase();
        int start = 0;
        int end = str.length() - 1;

        if(str.length() <= 1 ) return true;

        while(start <= end){
            if(str.charAt(start) != str.charAt(end)){
                return false;
            }
            start += 1;
            end -= 1;
        }

        return true;
    }

    //RECURSION
    public static boolean isPalindrome(String str){
        str = str.toLowerCase();
        if(str.length() <= 1 ) return true;

        if(str.charAt(0) == str.charAt(str.length()-1)){
            return isPalindrome(str.substring(1, str.length()-1));
        }

        return false;
    }
}