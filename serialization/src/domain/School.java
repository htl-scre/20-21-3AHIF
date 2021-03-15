package domain;

import java.io.Serializable;

public class School implements Serializable {

    private String name;

    public School(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "School{" +
               "name='" + name + '\'' +
               '}';
    }
}
