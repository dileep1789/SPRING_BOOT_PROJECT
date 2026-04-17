package SPRING_BOOT_PROJECT.service;

import SPRING_BOOT_PROJECT.dto.StudentDto;
import SPRING_BOOT_PROJECT.service.impl.StudentServiceimpl;

import java.util.List;

public interface StudentService  {

    List<StudentDto> getAllStudents();

}
