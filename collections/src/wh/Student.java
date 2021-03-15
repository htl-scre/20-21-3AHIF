package wh;

import java.util.*;

public class Student implements Comparable<Student>{

    private String name;
    private int nummer;

    public Student(String name, int nummer) {
        this.name = name;
        this.nummer = nummer;


    }

    public static void main(String[] args) {
        Set<Student> students = new TreeSet<>();

        students.add(new Student("Agatha",3));
        students.add(new Student("Lukas",Integer.MAX_VALUE));
        students.add(new Student("Jonas",Integer.MIN_VALUE));

        System.out.println(students);
    }

    @Override
    public int compareTo(Student o) {
        return Integer.compare(this.nummer, o.nummer);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", nummer=" + nummer +
                '}';
    }


}
