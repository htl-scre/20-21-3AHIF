package domain;

import java.io.*;

public class Student implements Serializable {

    private int hausnummer;
    private String name;
    private transient School school;
    public static String version = "v1";

    public Student(int hausnummer, String name, School school) {
        this.hausnummer = hausnummer;
        this.name = name;
        this.school = school;
    }

    @Serial
    private void writeObject(ObjectOutputStream output)
            throws IOException {
        output.writeInt(hausnummer);
        output.writeUTF(name.toUpperCase());
    }

    @Serial
    private void readObject(ObjectInputStream input)
            throws IOException, ClassNotFoundException {
        hausnummer = input.readInt();
        name = input.readUTF();
    }

    @Override
    public String toString() {
        return "Student{" +
               "id=" + hausnummer +
               ", name='" + name + '\'' +
               ", school=" + school +
               '}';
    }
}
