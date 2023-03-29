package com.app;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        //squares of numbers greater than 49
        List<Integer> list = Arrays.asList(1, 2, 3, 2, 4, 4, 5, 8, 9, 10);
        //find duplicates in an array
        Set<Integer> hs = new HashSet<>();
        Set<Integer> duplicates = list.stream().filter(integer -> !hs.add(integer)).collect(Collectors.toSet());
        Set<Integer> duplicates2 = list.stream().filter(integer -> Collections.frequency(list, integer) > 1)
                .collect(Collectors.toSet());
        int xx = 49;
        List<Integer> collect1 = list.stream().filter(integer -> integer * integer > xx).collect(Collectors.toList());
        System.out.println(collect1);

        Emp e1 = new Emp("Ahan", "IT", 10000);
        Emp e2 = new Emp("Dipanshu", "Comp", 20000);
        Emp e3 = new Emp("Zakir", "IT", 35000);
        Emp e4 = new Emp("Yuraj", "IT", 50000);
        Emp e5 = new Emp("Nadimpalli", "Comp", 15000);
        Emp e6 = new Emp("Madan", "Mech", 60000);
        Emp e10 = new Emp("Dipanshu", "EC", 500000);
        Emp e11 = new Emp("Dipanshu", "Comp", 1);

        List<Emp> empList = Arrays.asList(e1, e2, e3, e4, e5, e6, e10, e11);

        //print different departments in list
        empList.stream().map(Emp::getDept).distinct().forEach(System.out::println);

        //average salary by dept
        Map<String, Double> averageSalaryByDept = empList.stream()
                .collect(Collectors.groupingBy(Emp::getDept, Collectors.averagingInt(Emp::getSalary)));
        System.out.println("averageSalaryByDept->" + averageSalaryByDept);

        //3 employees with longest name length
        List<Emp> collect = empList.stream().sorted((o1, o2) -> o2.getName().length() - o1.getName().length())
                .limit(3)
                .collect(Collectors.toList());
        System.out.println("3 employees with longest names->" + collect);


        Optional<Emp> e = empList.stream().sorted((o1, o2) -> o2.getName().length() - o1.getName().length()).findFirst();
        System.out.println("employee with longest name->" + e.get());

        //sort by name, then by salary, then by dept
        List<Emp> collect2 = empList.stream()
                .sorted(
                        Comparator.comparing(Emp::getName).thenComparingInt(Emp::getSalary).thenComparing(Emp::getDept))
                .collect(Collectors.toList());

        System.out.println("sort by name, salary, dept->" + collect2);

        //group the employees by dept
        Map<String, List<Emp>> groupEmpByDept = empList.stream().collect(Collectors.groupingBy(Emp::getDept));
        System.out.println("Emp by Dept->" + groupEmpByDept);

        //get highest paid emp from each dept
        Map<String, Emp> highestPaidEmpInEachDept = empList.stream()
                .collect(Collectors.groupingBy(Emp::getDept,
                        Collectors.collectingAndThen(
                                Collectors.maxBy(Comparator.comparingInt(Emp::getSalary))
                                , emp -> emp.get())));

        System.out.println("highestPaidEmployeesInEachDept" + highestPaidEmpInEachDept);


    }

}

class Emp {
    private String name;
    private String dept;
    private int salary;

    public Emp(String name, String dept, int salary) {
        this.name = name;
        this.dept = dept;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "name='" + name + '\'' +
                ", dept='" + dept + '\'' +
                ", salary=" + salary +
                '}';
    }
}
