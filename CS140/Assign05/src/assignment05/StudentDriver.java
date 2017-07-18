package assignment05;
import java.util.ArrayList;
import java.util.Collections;

public class StudentDriver {

    public static void main(String[] args) {
        ArrayList<Student> list = new ArrayList<Student>();
        Student s;
        list.add(s = new GraduateStudent(new Person("Jane", "Jones"), "B00012345", "ABC"));
        s.setMajor("CCC");
        list.add(s = new GraduateStudent(new Person("Kevin", "Kay"), "B00012340", "DEF"));
        s.setMajor("AAA");
        list.add(s = new GraduateStudent(new Person("Colin", "Clarke"), "B00012350", "UUU"));
        s.setMajor("AAA");
        list.add(s = new Student(new Person("Linda", "Lake"), "B00012342"));
        s.setMajor("EEE");
        list.add(s = new Student(new Person("Bryan", "Brooks"), "B00012341"));
        s.setMajor("DDD");
        list.add(s = new Student(new Person("Alan", "Addams"), "B00012347"));
        s.setMajor("DDD");
        System.out.println(list);
        Collections.sort(list, new StudentComparator());
        System.out.println(list);
    }
}