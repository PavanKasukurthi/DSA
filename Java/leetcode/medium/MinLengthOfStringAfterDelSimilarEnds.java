package Java.leetcode.medium;

public class MinLengthOfStringAfterDelSimilarEnds{
    public static void main(String[] args) {
        System.out.println(minimumLength("ccbadcc"));
    }

    public static int minimumLength(String s) {
        int i = 0, j = s.length() - 1;

        while(i < j){
            if(s.charAt(i) != s.charAt(j)) break;

            else {
                while(i < j && s.charAt(i) == s.charAt(i+1)) i++;
                while(i < j && s.charAt(j) == s.charAt(j-1)) j--;
            }
            i++;
            j--;
        }

        return i > j ? 0 : (j-i+1);
    }
}