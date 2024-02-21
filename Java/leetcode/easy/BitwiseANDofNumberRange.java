package Java.leetcode.easy;

public class BitwiseANDofNumberRange {
    public int rangeBitwiseAnd(int left, int right){
        int result = left;

        while(left < right){
            result = right & (right - 1);
            right = result;
        }

        return result;
    }
}
