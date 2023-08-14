package Java.problems;

public class Power {
    public static void main(String[] args) {
        int result = power(5,2);
        if(result == -1){
            System.out.println("Enter a positive exponent");
        }
        System.out.println(result);
    }

    public static int power(int base, int exponent) {
        if(exponent < 0) return -1;
        if(exponent == 0) return 1;

        return base * power(base, exponent-1);
    }
}
