package Java.leetcode.easy;

public class MergeStringsAlternately {
    public static void main(String[] args) {
        System.out.println(mergeStringsAlternately("ab", "pqrs"));
    }
    
    public static String mergeStringsAlternately(String a, String b){
        StringBuilder result = new StringBuilder();
        int i = 0;
        int j = 0;

        while(i < word1.length() && j < word2.length()){
            result.append(word1.charAt(i++)).append(word2.charAt(j++));
        }

        if(i < word1.length()) result.append(word1.substring(i,word1.length()));
        
        if(j < word2.length()) result.append(word2.substring(j, word2.length()));
        
        return result.toString();
    }
}
