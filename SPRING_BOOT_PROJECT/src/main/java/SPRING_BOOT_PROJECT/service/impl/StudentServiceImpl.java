package SPRING_BOOT_PROJECT.service.impl;

import SPRING_BOOT_PROJECT.dto.AddStudentRequestDto;
import SPRING_BOOT_PROJECT.dto.StudentDto;
import SPRING_BOOT_PROJECT.entity.Student;
import SPRING_BOOT_PROJECT.repository.StudentRepository;
import SPRING_BOOT_PROJECT.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<StudentDto> getAllStudents() {

        List<Student> students = studentRepository.findAll();

        return students.stream()
                .map(student -> modelMapper.map(student, StudentDto.class))
                .toList();
    }

    @Override
    public StudentDto getStudentById(Long id) {

        Student student = studentRepository.findById(id)
                .orElseThrow(() ->
                        new IllegalArgumentException("Student not found with id: " + id)
                );

        return modelMapper.map(student, StudentDto.class);
    }

    @Override
    public StudentDto createNewStudent(AddStudentRequestDto addStudentRequestDto) {
        Student newStudent = modelMapper.map(addStudentRequestDto, Student.class);
        Student student = studentRepository.save(newStudent);
        return modelMapper.map(student, StudentDto.class);
    }

    @Override
    public void deleteStudentById(Long id) {
        if (!studentRepository.existsById(id)){
            throw new IllegalArgumentException("student not exits by id: " +id);
        }
        studentRepository.deleteById(id);
    }

    @Override
    public StudentDto updateStudent(Long id, AddStudentRequestDto addStudentRequestDto) {
        Student student = studentRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("student not found by id " + id));
        modelMapper.map(addStudentRequestDto,student);

        student = studentRepository.save(student);
        return modelMapper.map(student, StudentDto.class);
    }

    @Override
    public StudentDto updatePartialStudent(Long id, Map<String, Object> updates) {

        Student student = studentRepository.findById(id)
                .orElseThrow(() ->
                        new IllegalArgumentException("student not found with id " + id));

        for (Map.Entry<String, Object> entry : updates.entrySet()) {
            String field = entry.getKey();
            Object value = entry.getValue();
            switch (field) {

                case "name":
                    student.setName((String) value);
                    break;

                case "email":
                    student.setEmail((String) value);
                    break;

                default:
                    throw new IllegalArgumentException("Field is not supported: " + field);
            }
        }

        Student savedStudent = studentRepository.save(student);
        return modelMapper.map(savedStudent, StudentDto.class);
    }
}