package SPRING_BOOT_PROJECT.service.impl;

import SPRING_BOOT_PROJECT.dto.StudentDto;
import SPRING_BOOT_PROJECT.entity.Student;
import SPRING_BOOT_PROJECT.repository.StudentRepository;
import SPRING_BOOT_PROJECT.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceimpl implements StudentService {

    private final StudentRepository studentRepository;

    @Override
    public List<StudentDto> getAllStudents() {

        List<Student> students = studentRepository.findAll();

        return students.stream()
                .map(student -> new StudentDto(
                        student.getId(),
                        student.getName(),
                        student.getEmail()
                ))
                .toList();
    }
}