package Java.problems;

public class IsSubsequence {
    public static void main(String[] args) {
        System.out.println(isSubsequence("axc", "ahgdbc"));
    }

    public static boolean isSubsequence(String s, String t){

        if(s.length() == 0 || s.isEmpty()) return true;

        int i = 0, j = 0;
        
        while(i < s.length() && j < t.length()){
            if(s.charAt(i) == t.charAt(j)){
                i++;
            }
            j++;
        }

        if(i == s.length()) return true;

        return false;
    }
}
