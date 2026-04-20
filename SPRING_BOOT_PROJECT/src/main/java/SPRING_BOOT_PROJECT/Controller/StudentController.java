package SPRING_BOOT_PROJECT.Controller;

import SPRING_BOOT_PROJECT.dto.AddStudentRequestDto;
import SPRING_BOOT_PROJECT.dto.StudentDto;
import SPRING_BOOT_PROJECT.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    // ✅ FIXED: Return List<StudentDto>
    @GetMapping
    public ResponseEntity<List<StudentDto>> getStudent() {
        return ResponseEntity.ok(studentService.getAllStudents());
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentDto> getStudentById(@PathVariable Long id) {
        return ResponseEntity.ok(studentService.getStudentById(id));
    }

    @PostMapping
    public ResponseEntity<StudentDto> createNewStudent(
            @RequestBody AddStudentRequestDto addStudentRequestDto) {

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(studentService.createNewStudent(addStudentRequestDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAstudent(@PathVariable Long id){
        studentService.deleteStudentById(id);
        return ResponseEntity.noContent().build();

    }
}