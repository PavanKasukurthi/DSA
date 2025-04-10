package Java.hackerrank.easy;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class JavaSort {
    private int id;
    private String fname;
    private double cgpa;

    public JavaSort(int id, String fname, double cgpa) {
        this.id = id;
        this.fname = fname;
        this.cgpa = cgpa;
    }

    public int getId() {
        return id;
    }

    public String getFname() {
        return fname;
    }

    public double getCgpa() {
        return cgpa;
    }
}

class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int testCases = Integer.parseInt(in.nextLine());

        List<JavaSort> studentList = new ArrayList<JavaSort>();
        while (testCases > 0) {
            int id = in.nextInt();
            String fname = in.next();
            double cgpa = in.nextDouble();

            JavaSort st = new JavaSort(id, fname, cgpa);
            studentList.add(st);

            testCases--;
        }

        // SOLUTION
        studentList.sort(Comparator
                .comparing(JavaSort::getCgpa).reversed()
                .thenComparing(JavaSort::getFname)
                .thenComparing(JavaSort::getId));

        for (JavaSort st : studentList) {
            System.out.println(st.getFname());
        }
    }
}
