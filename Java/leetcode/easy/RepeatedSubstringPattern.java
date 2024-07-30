package Java.leetcode.easy;

public class RepeatedSubstringPattern {
    public static void main(String[] args) {
        System.out.println(repeatedSubstringPattern("abcabc"));
    }

    public static boolean repeatedSubstringPattern(String str){

        int len = str.length();
        for(int i = len/2 ; i > 0  ; i--){
            if(len %  i == 0){
                int repeats = len/i;
                String subStr = str.substring(0, i);
                StringBuilder sb = new StringBuilder();
                for(int j = 0 ; j < repeats ; j++){
                    sb.append(subStr);
                }
                if(sb.toString().equals(str)) return true;
            }
        }

        return false;
    }
}
