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

        //EMPLOYEES WHO KNOW JAVA AND C
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

        System.out.println();
        
        //EMPLOYEES WHOSE TECHSTACK STARTS WITH THE LETTER R
        System.out.println("Employees whose techstack starts with the letter R");
        List<Employee> employeesTechStackStartingWithR = employees.stream()
        .filter(e -> e.getTechStack().stream().anyMatch(t -> t.startsWith("R"))).collect(Collectors.toList());

        employeesTechStackStartingWithR.forEach(e -> System.out.print(e.getName() + " "));
        
        System.out.println();

        //EACH GENDER COUNT IN CIS DEPARTMENT
        System.out.println("Each gender count in CIS department");
        Map<String, Long> genderCountInCISDepartment = employees.stream()
        .filter(x -> x.getDepartment().equalsIgnoreCase("CIS"))
        .collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
        
        System.out.print("gender count: "  + genderCountInCISDepartment);

        System.out.println();

        //PRINT THE EMPLOYEES WHO KNOW JAVA AND C IN DX DEPARTMENT
        System.out.println("Print the employees who know Java and C in DX department");
        List<Employee> employeesWhoKnowJavaAndCInDX = employees.stream()
        .filter(x -> x.getDepartment().equalsIgnoreCase("DX") && x.getTechStack().contains("Java") && x.getTechStack().contains("C"))
        .collect(Collectors.toList());

        employeesWhoKnowJavaAndCInDX.forEach(e -> System.out.print(e.getName()));

        System.out.println();

        //PRINT THE EMPLOYEES WHO JOINED AFTER 2015 IN CIS DEPARTMENT
        System.out.println("Print the employees who joined after 2015 in CIS department");
        List<Employee> employeesWhoJoinedAfter2015InCIS = employees.stream()
        .filter(e -> e.getDepartment().equalsIgnoreCase("CIS") && e.getYearOfJoining() > 2015)
        .collect(Collectors.toList());

        employeesWhoJoinedAfter2015InCIS.forEach(e -> System.out.println(e.getName()));

        System.out.println();

        //PRINT THE EMPLOYEES WHOSE NAME STARTS WITH 'T' IN ENG DEPARTMENT
        System.out.println("Print the employees whose name starts with 'T' in ENG department");
        List<Employee> employeesNameStartingWithTInENG = employees.stream()
        .filter(e -> e.getDepartment().equalsIgnoreCase("ENG") && e.getName().startsWith("T")).collect(Collectors.toList());

        employeesNameStartingWithTInENG.forEach(e -> System.out.println(e.getName()));
        
        System.out.println();

        //PRINT THE EMPLOYEES WHOSE NAME CONTAINS 'U' IN THE LIST
        System.out.println("Print the employees whose name contains 'u' in the list");
        List<Employee> employeesWhoseNameContainsU = employees.stream()
        .filter(e -> e.getName().contains("u") || e.getName().contains("U")).collect(Collectors.toList());

        employeesWhoseNameContainsU.forEach(e -> System.out.println(e.getName()));

        System.out.println();

        //PRINT THE EMPLOYEES WHOSE TECHSTACK AS IN THE GIVEN LIST
        System.out.println("Employees techstack is same as the given list ");
        List<String> customTechStack = Arrays.asList("Java", "JavaScript", "C#");
        List<Employee> employeesWithSameTechStack = employees.stream()
        .filter(x -> x.getTechStack().containsAll(customTechStack))
        .collect(Collectors.toList());

        employeesWithSameTechStack.forEach(x -> System.out.println(x.getName()));

        System.out.println();

        //PRINT THE EMPLOYEES WHO HAS SAME TECHSTACK AS THE EMPLOYEE WITH ID 1
        System.out.println("Employees with the same techstack as the employee with id 1 ");
        List<String> firstEmployeeTechStack = employees.stream()
        .filter(e -> e.getId() == 1)
        .map(Employee::getTechStack)
        .flatMap(List::stream)
        .collect(Collectors.toList());

        List<Employee> employeesWithSameTechStackAsFirstEmployee = employees.stream()
        .filter(e -> e.getTechStack().containsAll(firstEmployeeTechStack))
        .collect(Collectors.toList());

        employeesWithSameTechStackAsFirstEmployee.forEach(e -> System.out.println(e.getName()));

        System.out.println();

        //PRINT THE EMPLOYEES WITH SAME TECHSTACKS
        System.out.println("Employees with same techStacks ");
        List<List<Object>> employeesWithSameTechStacks = employees.stream()
            .flatMap(e -> employees.stream()
                .filter(f -> !f.equals(e) && f.getTechStack().containsAll(e.getTechStack()))
                .map(f -> Arrays.asList(e.getName(), f.getName(), e.getTechStack())))
        .distinct()
        .collect(Collectors.toList());

        employeesWithSameTechStacks.forEach(e -> System.out.println(e.get(0) + " and " + e.get(1) + " have the same techStacks: " + e.get(2) + "\n"));

        System.out.println();

        //SORT EMPLOYEES BASED ON THEIR SALARIES
        System.out.println("Sort employees based on their salaries ");
        List<Employee> employeesSortedBasedOnTheirSalaries = employees.stream()
            .sorted((e,f) -> Double.compare(e.getSalary(), f.getSalary()))
            .collect(Collectors.toList());

        employeesSortedBasedOnTheirSalaries.forEach(e -> System.out.println(e.getName() + " -> " + e.getSalary()));

        System.out.println();

         //SORT EMPLOYEES BASED ON THEIR SALARIES IN DESCENDING OTDER
        System.out.println("Sort employees based on their salaries in descending order");
        List<Employee> employeesSortedBasedOnTheirSalariesDesc = employees.stream()
            .sorted((e,f) -> Double.compare(f.getSalary(), e.getSalary()))
            .collect(Collectors.toList());

        employeesSortedBasedOnTheirSalariesDesc.forEach(e -> System.out.println(e.getName() + " -> " + e.getSalary()));

        System.out.println();

        //SORT EMPLOYEES BASED ON THEIR SALARIES AND IF THE SALARIES ARE SAME THEN SORT THEM BASED ON THEIR AGE
        System.out.println("Sort the employees based on their salaries and if the salaries are same then sort them based on their age ");
        List<Employee> employeesSortedBasedOnTheirSalariesAndAge = employees.stream()
            .sorted((e,f) -> e.getSalary() == f.getSalary() ? Integer.compare(e.getAge(), f.getAge()) : Double.compare(e.getSalary(), f.getSalary()))
            .collect(Collectors.toList());

        employeesSortedBasedOnTheirSalariesAndAge.forEach(e -> System.out.println(e.getName() + " -> " + e.getSalary() + " -> " + e.getAge()));
    }
}
