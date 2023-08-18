package Java.leetcode.easy;

public class IndexOfFirstOccurenceInAString {
    public static void main(String[] args) {
        System.out.println(strStr("sadbutsad", "sad"));
    }

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
}
