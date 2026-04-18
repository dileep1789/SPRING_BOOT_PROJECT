package SPRING_BOOT_PROJECT.Controller;

import SPRING_BOOT_PROJECT.dto.AddStudentRequestDto;
import SPRING_BOOT_PROJECT.dto.StudentDto;
import SPRING_BOOT_PROJECT.entity.Student;
import SPRING_BOOT_PROJECT.repository.StudentRepository;
import SPRING_BOOT_PROJECT.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;



    @GetMapping("/students")
    public ResponseEntity<StudentDto> getStudent(){
//        return studentService.getAllStudents();
        return ResponseEntity.ok((StudentDto) studentService.getAllStudents());

    }

    @GetMapping("/students/{id}")
    public ResponseEntity<StudentDto> getStudentById(@PathVariable Long id) {
        return ResponseEntity.ok(studentService.getStudentById(id));
    }

    @PostMapping
    public ResponseEntity<StudentDto> createNewStudent(@RequestBody AddStudentRequestDto addStudentRequestDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(studentService.createNewStudent(addStudentRequestDto));
    }



}
