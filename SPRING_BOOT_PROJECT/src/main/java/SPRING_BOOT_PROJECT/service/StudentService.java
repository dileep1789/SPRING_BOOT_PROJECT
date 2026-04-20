package SPRING_BOOT_PROJECT.service;

import SPRING_BOOT_PROJECT.dto.AddStudentRequestDto;
import SPRING_BOOT_PROJECT.dto.StudentDto;

import java.util.List;

public interface StudentService  {

    List<StudentDto> getAllStudents();

    StudentDto getStudentById(Long id);

    StudentDto createNewStudent(AddStudentRequestDto addStudentRequestDto);

    void deleteStudentById(Long id);
}
