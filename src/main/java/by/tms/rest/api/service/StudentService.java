package by.tms.rest.api.service;

import by.tms.rest.api.dto.StudentDto;

import java.util.List;

public interface StudentService {

    List<StudentDto> getAllStudents();

    StudentDto getStudent(Long id);

    void addStudent(StudentDto student);

    void updateStudent(Long id, StudentDto updatedStudent);

    void deleteStudent(Long id);

    StudentDto getStudentByNameAndSurname(String name, String surname);

    StudentDto getStudentByName(String name);
}
