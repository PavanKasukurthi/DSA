package Java.geekforgeeks.medium;

public class ColumnNameFromColNumber {
    public static void main(String[] args) {
        System.out.println(columnNameFromColNumber(5));
    }

    public static String columnNameFromColNumber(long n){
        String colName = "";

        while(n > 0){
            long val = (n-1)%26;
            colName = (char)(val + 'A') + colName;
            n = (n-1)/26;
        }

        return colName;
    }
}
