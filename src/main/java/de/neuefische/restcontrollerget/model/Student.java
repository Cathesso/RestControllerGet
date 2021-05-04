package de.neuefische.restcontrollerget.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Objects;

public class Student {
    @NotBlank(message = "student id is required")
    private String id;
    @NotBlank(message = "student name is required")
    @Size(min = 2, max = 30, message = "student name is required")
    private String name;

    public Student(String name, String id) {
        this.name = name;
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
