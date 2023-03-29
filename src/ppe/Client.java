package ppe;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Client {
    public static void main(String[] args) {
        Test test = new TestImpl();
        test.testInterface();

        TestAbstractClass testAbstractClassExt = new TestAbstractClassExt();

        List<String> list = Arrays.asList("Dipanshu", "Chaitanya", "Ram", "John", "Jorden");


        List<String> all = list.stream().filter(n -> n.contains("a"))
                .map(n -> n.concat("123"))
                .collect(Collectors.toList());
        System.out.println(all);


        //student , marks
        //sname sid , sid subject marks

        //students with highest marks in all subjects
        //select subject, smane, max(marks) from student inner join marks on student.sid=marks.sid group by subject

        //subject name marks


    }
}
