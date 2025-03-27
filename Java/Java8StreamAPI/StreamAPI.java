package Java.Java8StreamAPI;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamAPI {
    public static void main(String[] args) {
        Employee e1 = new Employee(1, "Antman", 39, "Male", "DX", 2011, 100000, Arrays.asList("Ruby", "Java", "C"));
        Employee e2 = new Employee(2, "Sam", 24, "Male","ENG" , 2017, 76000, Arrays.asList(".Net", "JavaScript", "C++"));
        Employee e3 = new Employee(8, "Carol", 30, "Female", "CIS", 2013, 85000, Arrays.asList("Java", "C#", "python"));
        Employee e4 = new Employee(3, "Tony", 25,"Male", "HR", 2010, 90000, Arrays.asList("Angular", "Python", "C"));
        Employee e5 = new Employee(4, "Hercules", 42, "Male", "DX", 2015, 28000, Arrays.asList("Java", ".Net", "React"));
        Employee e6 = new Employee(9, "Bruce", 27, "Male", "CIS", 2020, 68000, Arrays.asList("Java", "JavaScript", "C#"));
        Employee e7 = new Employee(6, "Patsy", 28, "Female", "HR", 2022, 30000, Arrays.asList("C++", "Ruby", "Java"));
        Employee e8 = new Employee(7, "Natasha", 55, "Female", "HR", 2020, 53000, Arrays.asList("C#", "Python", "C++"));
        Employee e9 = new Employee(5, "Wanda", 31, "Female", "ENG", 2023, 25000, Arrays.asList(".Net", "Ruby", "C#"));
        Employee e10 = new Employee(10, "Vision", 32, "Robot",  "CIS", 2021, 34000, Arrays.asList("Java", ".Net", "C#"));
        Employee e11 = new Employee(11, "Wasp", 33, "Female", "DX", 2001, 80070, Arrays.asList("Ruby", "JavaScript", "C++"));
        Employee e12 = new Employee(12, "Thor", 34, "Male", "ENG", 2018, 56000, Arrays.asList(".Net", "Java", "C++"));
        Employee e13 = new Employee(13, "Thanos", 35, "Male", "CIS", 2019, 67000, Arrays.asList("JavaScript", "C#", "Java"));

        List<Employee> employees = Arrays.asList(e1, e2, e3, e4, e5, e6, e7, e8, e9, e10, e11, e12, e13);

        //COUNT THE EMPLOYEES BASED ON THE GENDER
        System.out.println("Counting the number of employees based on the gender");
        long maleCount = employees.stream().filter(e -> e.getGender().equalsIgnoreCase("Male")).count();
        long femaleCount = employees.stream().filter(e -> e.getGender().equalsIgnoreCase("Female")).count();
        long otherCount = employees.stream().filter(e -> e.getGender().equalsIgnoreCase("Robot")).count();
        System.out.println("Male count: " + maleCount + " " + "Female count: " + femaleCount + " " + "Other count: " + otherCount);

        System.out.println();

        //DEPARTMENT WISE GENDER COUNT
        System.out.println("Department wise gender count");
        Map<String, Map<String, Long>> departmentWiseGenderCount = employees.stream()
        .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.groupingBy(Employee::getGender, Collectors.counting())));

        System.out.println("Department wise gender count: " + departmentWiseGenderCount);

        System.out.println();

        //AVERAGE SALARY OF MALE EMPLOYEES, FEMALE EMPLOYEES AND OTHER EMPLOYEES
        System.out.println("Average Salary of male employees, female employees and other employees");
        double avgMaleSalary = employees.stream().filter(e -> e.getGender().equals("Male")).mapToDouble(Employee::getSalary).average().orElse(0);
        double avgFemaleSalary = employees.stream().filter(e -> e.getGender().equals("Female")).mapToDouble(Employee::getSalary).average().orElse(0);
        double avgOtherSalary = employees.stream().filter(e -> e.getGender().equals("Robot")).mapToDouble(Employee::getSalary).average().orElse(0);

        System.out.println("Average male salary: " + avgMaleSalary + " Average female salary: " + avgFemaleSalary + " Average other salary: " + avgOtherSalary);

        System.out.println();

        //PRINT THE EMPLOYEE DETAILS WITH MAX AND MIN SALARY
        System.out.println("Employee details with minimum and maximum salary");
        // Employee maxSalaryEmployee = employees.stream().max((e,f) -> Double.compare(e.getSalary(), f.getSalary())).get();
        //Using Comparator
        Employee maxSalaryEmployee = employees.stream().max(Comparator.comparing(Employee::getSalary)).get();
        Employee minSalaryEmployee = employees.stream().min((e,f) -> Double.compare(e.getSalary(), f.getSalary())).get();

        System.out.println("Max Salary Employee: " + maxSalaryEmployee.getName());
        System.out.println("Min Salary Employee: " + minSalaryEmployee.getName());

        System.out.println();


        //EMPLOYEES WHO JOINED AFTER 2015
        System.out.println("Employees who joined after 2015");

        List<Employee> employeesAfter2015 = employees.stream().filter(e -> e.getYearOfJoining() > 2015).collect(Collectors.toList());
        employeesAfter2015.forEach(e -> System.out.print(e.getName() + " "));

        System.out.println();

        //EMPLOYEES WHOSE NAMES START WITH LETTER T
        System.out.println("Employees whose names starts with letter T");

        List<Employee> employeesStartingWithT = employees.stream().filter(e -> e.getName().startsWith("T")).collect(Collectors.toList());
        employeesStartingWithT.forEach(e -> System.out.print(e.getName() + ", "));
        
        System.out.println();

        //EMPLOYEES WHO KNOW JAVA
        System.out.println("Employees who know java");
        List<Employee> employeesWhoKnowJava = employees.stream().filter(e -> e.getTechStack().contains("Java")).collect(Collectors.toList());
        employeesWhoKnowJava.forEach(e -> System.out.print(e.getName() + " "));

        //EMPLOYEES WHO KNOW JAVA AND C++
        System.out.println("Employees who know Java and C");
        List<Employee> employeesWhoKnowJavaAndC = employees.stream().filter(e -> e.getTechStack().contains("Java") && e.getTechStack().contains("C")).collect(Collectors.toList());
        employeesWhoKnowJavaAndC.forEach(e -> System.out.print(e.getName() + " "));

        System.out.println();

        //EMPLOYEES AND THEIR SALARIES WHO EARN THE MOST IN THEIR DEPARTMENT
        System.out.println("Employees who earn the most in their department");

        Map<String, Employee> employeeMaxSalaryInDepartment = employees.stream()
        .collect(Collectors.groupingBy(Employee::getDepartment, 
        Collectors.collectingAndThen(Collectors.maxBy((e,f) -> Double.compare(e.getSalary(), f.getSalary())), e -> e.get())));

        employeeMaxSalaryInDepartment.forEach((k,v) -> System.out.println(k + " --> " + v.getName() + " --> " + v.getSalary()));

        System.out.println();

         //EMPLOYEES AND THEIR SALARIES WHO EARN THE LEAST IN THEIR DEPARTMENT
        System.out.println("Employees who earn the least in their department");

        Map<String, Employee> employeeMinSalaryInDepartment = employees.stream()
        .collect(Collectors.groupingBy(Employee::getDepartment, 
        Collectors.collectingAndThen(Collectors.minBy((e,f) -> Double.compare(e.getSalary(), f.getSalary())), e -> e.get())));

        employeeMinSalaryInDepartment.forEach((k,v) -> System.out.println(k + " --> " + v.getName() + " --> " + v.getSalary()));

        System.out.println();

        //EMPLOYEES WHO EARN MORE THAN 50000
        System.out.println("Employees who earn more than 50000");
        List<Employee> employeesWithSalaryGreaterThan5000 = employees.stream().filter(e -> e.getSalary() > 50000).collect(Collectors.toList());

        employeesWithSalaryGreaterThan5000.forEach(e -> System.out.println(e.getName() + " --> " +  e.getSalary() + "\t"));

        //EMPLOYEES WHOSE TECHSTACK STARTS WITH THE LETTER R
        System.out.println("Employees whose techstack starts with the letter R");
        List<Employee> employeesTechStackStartingWithR = employees.stream()
        .filter(e -> e.getTechStack().stream().anyMatch(t -> t.startsWith("R"))).collect(Collectors.toList());

        employeesTechStackStartingWithR.forEach(e -> System.out.print(e.getName() + " "));
        
        System.out.println();
    }
}
