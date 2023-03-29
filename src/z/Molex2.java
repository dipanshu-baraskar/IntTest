package z;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Molex2 {
    public static void main(String[] args) {
        Employee e1 = new Employee(1, "Dipa", 1000, "Comp");
        Employee e2 = new Employee(2, "Ram", 10000, "IT");
        Employee e3 = new Employee(3, "Shyam", 15000, "Mech");
        Employee e4 = new Employee(4, "Bob", 21000, "Comp");
        Employee e5 = new Employee(5, "Peter", 31000, "IT");
        Employee e6 = new Employee(6, "Sank", 1050, "Mech");
        Employee e7 = new Employee(7, "Maria", 6000, "ETC");
        List<Employee> list = Arrays.asList(e1, e2, e3, e4, e5, e6, e7);

        Map<String, List<String>> collect =
                list.stream()
                        .collect(Collectors.groupingBy(Employee::getDept
                                , () -> new TreeMap<>(Collections.reverseOrder()),
                                Collectors.mapping(Employee::getName,
                                        Collectors.toList())));

        System.out.println(collect);
        Predicate<Employee> isCondition = emp -> emp.getDept().equals("IT") && emp.getSalary() > 2000;
        List<String> it = list.stream().filter(isCondition)
                .map(Employee::getName).collect(Collectors.toList());
    }


    public static class Employee {
        private int id;
        private String name;
        private int salary;

        private String dept;

        public Employee(int id, String name, int salary, String dept) {
            this.id = id;
            this.name = name;
            this.salary = salary;
            this.dept = dept;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public int getSalary() {
            return salary;
        }

        public String getDept() {
            return dept;
        }
    }
}
