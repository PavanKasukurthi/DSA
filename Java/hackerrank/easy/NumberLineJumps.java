package Java.hackerrank.easy;

public class NumberLineJumps {
    
    public static String kangaroo(int x1, int v1, int x2, int v2){

        if(x1 == x2) return "YES";
        if(v1 == v2) return "NO";
        if((x1 > x2 && v1 > v2) && (x1 < x2 && v1 < v2)) return "NO";

        double jumps = (double)(x1 - x2)/(v2 - v1);

        return jumps == Math.floor(jumps) ? "YES" : "NO";
    }
}
