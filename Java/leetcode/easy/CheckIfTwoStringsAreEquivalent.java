package Java.leetcode.easy;

public class CheckIfTwoStringsAreEquivalent {
    public static void main(String[] args) {
       String[] word1 = {"ab", "c"};
       String[] word2 = {"a", "bc"};

       System.out.print(arrayStringsAreEquals(word1, word2));
    }

    //USING STRINGS
    public static boolean arrayStringsAreEqual(String[] word1, String[] word2) {

        return String.join("", word1).equals(String.join("", word2));
    }

    //USING STRINGBUILDER
    public static boolean arrayStringsAreEquals(String[] word1, String[] word2) {
        StringBuilder str1 = new StringBuilder();
        StringBuilder str2 = new StringBuilder();

        for(String s : word1) str1.append(s);
        for(String s : word2) str2.append(s);

        if(str1.compareTo(str2) == 0) return true;

        return false;
    }
}
