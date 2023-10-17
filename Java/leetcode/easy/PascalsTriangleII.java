package Java.leetcode.easy;
import java.util.ArrayList;
import java.util.List;

public class PascalsTriangleII {
    public static void main(String[] args) {
        System.out.println(getRow(3));
    }

    public static List<Integer> getRow(int rowIndex){
        List<Integer> list = new ArrayList<>();

        for(int i = 0 ; i <= rowIndex ; i++){
            list.add(1);
        }

        for(int i = 1 ; i < rowIndex ; i++){
            for(int j = i ; j > 0 ; j--){
                list.set(j, list.get(j) + list.get(j-1));
            }
        }

        return list;
    }
}
