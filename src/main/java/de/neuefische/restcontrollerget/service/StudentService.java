package de.neuefische.restcontrollerget.service;

import de.neuefische.restcontrollerget.model.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

@Service
public class StudentService {
    private final List<Student> students = List.of(
            new Student("Fabian", "1"),
            new Student("Jonathan", "2"),
            new Student("Mario", "3"),
            new Student("Sebastian", "4")
    );

    public List<Student> list() {
        return students;
    }

    public Optional<Student> findById(String id) {
        //System.out.println("ID wird abgerufen! Die gesuchte ID ist: " + id);
        for (Student student : students) {
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
        for (Student student : students) {
            if(student.getName().toLowerCase().contains(letter.toLowerCase())){
                findByLetterResult.add(student);
            }
        }
        return Optional.of(findByLetterResult);
    }
}
