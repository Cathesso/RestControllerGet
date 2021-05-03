package de.neuefische.restcontrollerget.controller;

import de.neuefische.restcontrollerget.model.Student;
import de.neuefische.restcontrollerget.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("student")
public class StudentController {
    StudentService studService = new StudentService();

    @GetMapping("allStudents")
    public List<Student> getStudents(){
        return studService.list();
    }

    @GetMapping
    public Optional<List<Student>> getStudentByLetter(@RequestParam Optional<String> letter){
        if (!letter.get().toString().equals("")){
            return studService.findByLetter(letter.get().toString());
        }
        return Optional.empty();
    }

    @GetMapping(path = "{id}")
    public Optional<Student> getStudentById(@PathVariable String id){
        return studService.findById(id);
    }


    /*

    @GetMapping(path = "{id}")
    public Optional<Student> getStudentById(@PathVariable String id){
        Optional<Student> chosenStudent = new StudentenService().findById(id);
        return chosenStudent;
    }

    @GetMapping
    public List<Student> search(@RequestParam String q){
        return new StudentenService().findByLetter(q);
    }
    */

}