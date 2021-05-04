package de.neuefische.restcontrollerget.controller;

import de.neuefische.restcontrollerget.model.Student;
import de.neuefische.restcontrollerget.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("student")
public class StudentController {
    //StudentService studService = new StudentService();
    private final StudentService studService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studService = studentService;
    }


    @GetMapping
    public Optional<List<Student>> getStudentByLetter(@RequestParam Optional<String> search){
        if (search.isPresent() && !search.get().isBlank()){
            return studService.findByLetter(search.get().toString());
        }
        //return studService.list();
        return Optional.empty();
    }

    @GetMapping(path = "{id}")
    public Optional<Student> getStudentById(@PathVariable String id){

        return studService.findById(id);
    }

    @PostMapping()
    public Student addStudent(@RequestBody @Valid Student student){
        if (student!=null){
            if(studService.findById(student.getId()).isEmpty()) {
                System.out.println("Studi wird hinzugefügt: " + student);
                studService.addStudent(student);
            }
            else{
                System.out.println("Studi wird gelöscht: " + studService.findById(student.getId()));
                studService.removeStudent(studService.findById(student.getId()).get());
                System.out.println("Studi wird hinzugefügt: " + student);
                studService.addStudent(student);
            }
        }
        else{
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Da stimmt was mit dem Studenten nicht. Sind Sie vielleicht ein bisschen dumm?");
        }
        return student;
    }

}