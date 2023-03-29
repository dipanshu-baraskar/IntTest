package z;

import java.util.*;
import java.util.stream.Collectors;

public class Sa {

    public static void main(String[] args) {

        Employee e1 = new Employee(1, "Ram", Arrays.asList("java", "spring"));
        Employee e2 = new Employee(2, "Akash", Arrays.asList("java", "hibernate"));

        List<Employee> eList = Arrays.asList(e1, e2);

        List<String> collect = eList.stream()
                .flatMap(employee -> employee.skills.stream())
                .distinct()
                .collect(Collectors.toList());
        System.out.println(collect);
        int[] a = {5, 4, 3, 2, 3, 6};
        int sum = 7;
        sum(a, sum);

        String s = "Please  Excuse My Dear Aunt Sally";
        s.chars()
                .filter(c -> Character.isUpperCase((char) c) && !Character.isWhitespace((char) c))
                .forEach(c -> System.out.print((char) c));

        OptionalInt first = s.chars().findFirst();
        System.out.println(first);
    }

    private static void sum(int[] a, int k) {
        Set<Integer> set = new LinkedHashSet<>();

        for (int i = 0; i < a.length; i++) {
            int temp = k - a[i];
            if (set.contains(temp)) {
                System.out.println(temp + " " + a[i]);
            }
            set.add(a[i]);
        }
    }

    static class Employee {
        int id;
        String name;
        List<String> skills;

        public Employee(int id, String name, List<String> skills) {
            this.id = id;
            this.name = name;
            this.skills = skills;
        }
    }

}
