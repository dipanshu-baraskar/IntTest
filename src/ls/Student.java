package ls;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Student {

    private String name;
    private int marks;

    private String section;


    public Student(String name, int marks, String section) {
        this.name = name;
        this.marks = marks;
        this.section = section;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", marks=" + marks +
                ", section='" + section + '\'' +
                '}';
    }

    public static void main(String[] args) {
        Student s1 = new Student("A", 50, "A");
        Student s2 = new Student("D", 70, "A");
        Student s3 = new Student("B", 100, "B");
        Student s4 = new Student("C", 80, "B");

        List<Student> studentList = Arrays.asList(s1, s2, s3, s4);

        OptionalDouble average = studentList.stream().mapToInt(Student::getMarks).average();

        Optional<Student> max = studentList.stream().max(Comparator.comparingInt(Student::getMarks));
        System.out.println(max.get().getMarks());


        Map<String, Integer> collect = studentList.stream().collect(Collectors
                .groupingBy(Student::getSection,
                        Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparingInt(Student::getMarks)),
                                student -> student.get().getMarks())));

        OptionalDouble average1 = studentList.stream().mapToInt(Student::getMarks).average();
        System.out.println(average1.getAsDouble());

        System.out.println(collect);
    }
}
