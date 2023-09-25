package Java.leetcode.easy;

public class FindTheDifference {
    public static void main(String[] args) {
        System.out.println(findTheDifference("abcd", "abcde"));
    }

    //USING ASCII VALUES
    public static char findTheDifference(String s, String t){
        char[] a1 = s.toCharArray();
        char[] a2 = t.toCharArray();

        int total = 0;

        for(char ch : a2){
            total = total + ch;
        }

        for(char ch : a1){
            total = total - ch;
        }

        return (char)total;
    }
}
