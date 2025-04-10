package Java.hackerrank.easy;

import java.util.HashMap;
import java.util.Scanner;

public class JavaMap {
    public static void main(String[] argh) {

        HashMap<String, Integer> contact = new HashMap<>();

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        for (int i = 0; i < n; i++) {
            String name = in.nextLine();
            int phone = in.nextInt();
            in.nextLine();

            contact.put(name, phone);
        }
        while (in.hasNext()) {
            String s = in.nextLine();

            if(contact.containsKey(s)){
                System.out.println(s + "=" + contact.get(s));
            }
            else System.out.println("Not Founds");
        }
    }
}
