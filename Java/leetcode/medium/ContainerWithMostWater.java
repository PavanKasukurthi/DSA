package Java.leetcode.medium;

public class ContainerWithMostWater {
    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(height));
    }

    //TWO POINTERS
    public static int maxArea(int[] height){
        int max_area = 0;
        int left = 0, right = height.length - 1;
        while( left < right ){
            if(height[left]< height[right]){
                max_area = Math.max(max_area, height[left] * (right - left));
                left++;
            }else {
                max_area = Math.max(max_area, height[right] * (right - left));
                right--;
            }
        }

        return max_area;
    }
}
