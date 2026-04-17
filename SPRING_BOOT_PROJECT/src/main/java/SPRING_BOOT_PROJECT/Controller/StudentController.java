package SPRING_BOOT_PROJECT.Controller;

import SPRING_BOOT_PROJECT.dto.StudentDto;
import SPRING_BOOT_PROJECT.entity.Student;
import SPRING_BOOT_PROJECT.repository.StudentRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentController {

    private final StudentRepository studentRepositoty;

    public StudentController(StudentRepository studentRepositoty) {
        this.studentRepositoty = studentRepositoty;
    }

    @GetMapping("/student")
    public List<Student> getStudent(){
        return studentRepositoty.findAll();
    }

    @GetMapping("/student/{id}")
    public StudentDto getStudentById(){
        return new StudentDto(4l,"AYUSH","ayush@gmail.com");
    }



}
