package ls;

import sun.reflect.generics.tree.Tree;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TT {
    public static void main(String[] args) {
        Employee e1 = new Employee(1, "Ram", 15000);
        Employee e2 = new Employee(2, "John", 20000);
        Employee e9 = new Employee(9, "John", 20000);
        Employee e3 = new Employee(3, "Amar", 5000);
        Employee e4 = new Employee(4, "Pavan", 17000);
        Employee e5 = new Employee(5, "Akshay", 25000);
        Employee e10 = new Employee(5, "Puskar", 25000);
        Employee e11 = new Employee(5, "Mandh", 25000);
        Employee e6 = new Employee(6, "Shubham", 8000);
        Employee e7 = new Employee(7, "Tom", 5000);
        Employee e8 = new Employee(8, "She", 8000);

        List<Employee> list = Arrays.asList(e1, e2, e3, e4, e5, e6, e7, e8, e9, e10, e11);

        List<Integer> collect = list.stream().map(Employee::getSalary)
                .distinct()
                .sorted((o1, o2) -> o2 - o1)
                .collect(Collectors.toList());

        int input = 1;
        int limit = collect.get(input - 1);

        List<Employee> highest = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getSalary() >= limit) {
                highest.add(list.get(i));
            }
        }

        System.out.println(highest);
/////////////////////////////////////////////
        TreeMap<Integer, List<Employee>> mapCol = list.stream()
                .collect(Collectors.groupingBy(Employee::getSalary,
                        () -> new TreeMap<>((o1, o2) -> o2 - o1),
                        Collectors.toList()));

        List<Employee> opL = new ArrayList<>();
        for (Map.Entry<Integer, List<Employee>> mm : mapCol.entrySet()) {
            if (mm.getKey() > input-1) {
                opL.addAll(mm.getValue());
            }
        }

        for(int i=0;i<input;i++){

        }

        System.out.println(opL);
///////////////////////////////////

    }

    public static class Employee {
        int id;
        String name;
        int salary;

        public Employee(int id, String name, int salary) {
            this.id = id;
            this.name = name;
            this.salary = salary;
        }

        @Override
        public String toString() {
            return "Employee{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", salary=" + salary +
                    '}';
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

    }
}
