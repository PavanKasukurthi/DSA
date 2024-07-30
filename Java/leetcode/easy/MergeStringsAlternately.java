package Java.leetcode.easy;

public class MergeStringsAlternately {
    public static void main(String[] args) {
        System.out.println(mergeStringsAlternately("ab", "pqrs"));
    }
    
    public static String mergeStringsAlternately(String a, String b){
        String mix = "";
        int i = 0;
        int j = 0;

        while (i < a.length() && j < b.length()){
            mix = mix + a.charAt(i++) + b.charAt(j++);
        }

        if(i < a.length()) mix = mix + a.substring(i, a.length());
        if(j < b.length()) mix = mix + b.substring(j, b.length());

        return mix;
    }
}
