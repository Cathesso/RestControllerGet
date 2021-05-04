package de.neuefische.restcontrollerget.service;

import de.neuefische.restcontrollerget.db.StudentDataBase;
import de.neuefische.restcontrollerget.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

@Service
public class StudentService {
    private final StudentDataBase studDataBase;
    @Autowired
    public StudentService(StudentDataBase studDataBase) {
        this.studDataBase = studDataBase;
    }




    public List<Student> list() {
        return studDataBase.getStudents();
    }

    public Optional<Student> findById(String id) {
        //System.out.println("ID wird abgerufen! Die gesuchte ID ist: " + id);
        for (Student student : studDataBase.getStudents()) {
            if(student.getId().equals(id)){
                return Optional.of(student);
            }
        }
        return Optional.empty();
    }



    public Optional<List<Student>> findByLetter(String letter) {
        List<Student> findByLetterResult = new ArrayList<Student>();
        if (letter == null){
            return Optional.empty();
        }
        for (Student student : studDataBase.getStudents()) {
            if(student.getName().toLowerCase().contains(letter.toLowerCase())){
                findByLetterResult.add(student);
            }
        }
        return Optional.of(findByLetterResult);
    }


    public void addStudent(Student student) {
        studDataBase.addStudent(student);
    }

    public void removeStudent(Student student) {
        studDataBase.removeStudent(student);
    }
}
