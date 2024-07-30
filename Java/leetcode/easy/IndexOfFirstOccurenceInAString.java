package Java.leetcode.easy;

public class IndexOfFirstOccurenceInAString {
    public static void main(String[] args) {
        System.out.println(strStr("sadbutsad", "sad"));
    }

    //USING WHILE LOOP
    public static int strStr(String hayStack, String needle){
        int left = 0;
        int right = needle.length();

        while(right <= hayStack.length()){
            if(hayStack.substring(left,right).equals(needle)){
                return left;
            }
            left+=1;
            right+=1;
        }
        return -1;
    }

    //USING FOR LOOP
    public int strStr2(String haystack, String needle) {
        int i = 0;
        for(int j = needle.length() ; j <= haystack.length() ; j++){
            if(haystack.substring(i,j).equals(needle)){
                return i;
            }
            i++;
        }
        return -1;
    }
}
