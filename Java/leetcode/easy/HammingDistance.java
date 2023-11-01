package Java.leetcode.easy;

public class HammingDistance{

    public static void main(String[] args) {
        hammingDistance(1,4);
    }

    public static int hammingDistance(int x, int y){
        int count = 0;
    	int res = x^y;
        System.out.println(res);
    	while(res > 0) {
    		if((res&1) == 1) {
    			count++;
    		}
    		res>>=1;
    	}
    		return count;
    }
}