package Java.leetcode.easy;

public class BackSpaceStringCompare {
    public static void main(String[] args) {
        String s = "ab#c";
        String t = "bd#c";
        System.out.println(backspaceCompare(s, t));
    }

    public static boolean backspaceCompare(String s, String t){

        int i = s.length() - 1;
        int j = t.length() - 1;

        int i_skips = 0;
        int j_skips = 0;

        while( i >= 0 || j >= 0){

            while(i >=0){
                if(s.charAt(i) == '#'){
                    i_skips++;
                    i--;
                }
                else if(i_skips > 0){
                    i--;
                    i_skips--;
                }
                else{
                    break;
                }
            }

            while(j >=0){
                if(t.charAt(j) == '#'){
                    j_skips++;
                    j--;
                }
                else if(j_skips > 0){
                    j--;
                    j_skips--;
                }
                else{
                    break;
                }
            }

            if((i>=0) && (j>=0) && s.charAt(i) != t.charAt(j)) return false;

            if((i>=0) != (j>=0)) return false;

            i -= 1;
            j -= 1;

        }

        return true;
    }
}
