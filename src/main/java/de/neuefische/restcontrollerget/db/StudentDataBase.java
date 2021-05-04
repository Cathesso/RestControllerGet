package de.neuefische.restcontrollerget.db;

import de.neuefische.restcontrollerget.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentDataBase {

    private final List<Student> students = new ArrayList<>(List.of(
            new Student("Fabian", "1"),
            new Student("Jonathan", "2"),
            new Student("Mario", "3"),
            new Student("Sebastian", "4")
    ));

    public void addStudent(Student student){
        students.add(student);
    }

    public void removeStudent(Student student){
        students.remove(student);
    }

    public List<Student> getStudents() {
        return students;
    }
}
