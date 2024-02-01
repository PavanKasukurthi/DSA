package Java.interviewbit.easy;

import java.util.ArrayList;
import java.util.Collections;

public class HighestProduct {
    public static void main(String[] args) {

        ArrayList<Integer> A = new ArrayList<>();

        A.add(0);
        A.add(-1);
        A.add(3);
        A.add(100);
        A.add(70);
        A.add(50);

        System.out.println(highestProduct(A));
    }

    public static int highestProduct(ArrayList<Integer>  A){

        Collections.sort(A);

        int n = A.size();

        int lo2hi1 = A.get(0) * A.get(1) * A.get(n-1);
        int hi3 = A.get(n-1) * A.get(n-2) * A.get(n-3);

        return Math.max(hi3, lo2hi1);
    }
}
