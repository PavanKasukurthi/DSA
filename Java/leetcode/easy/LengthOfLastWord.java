package Java.leetcode.easy;

public class LengthOfLastWord{
    public static void main(String[] args) {
        System.out.println(lengthOfLastWord("   fly me   to   the moon  "));
    }

    public static int lengthOfLastWord(String str){
        String[] s = str.trim().split(" ");
        return s[s.length-1].length();
    }
}