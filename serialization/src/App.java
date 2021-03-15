import domain.School;
import domain.Student;

import java.io.*;

public class App {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        School htl = new School("HTL");
        Student student = new Student(42, "Bob", htl);

        try (ObjectInputStream input = new ObjectInputStream(
                new FileInputStream("student.dat"))) {
            Student deserialized = (Student) input.readObject();
            System.out.println(deserialized);
        }
    }

    private static void serialize(Student student) throws IOException {
        try (ObjectOutputStream output = new ObjectOutputStream(
                new FileOutputStream("student.dat"))) {
            output.writeObject(student);
        }
    }
}
