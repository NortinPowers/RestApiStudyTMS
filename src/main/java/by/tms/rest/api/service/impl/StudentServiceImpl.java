package by.tms.rest.api.service.impl;

import by.tms.rest.api.domain.Student;
import by.tms.rest.api.dto.StudentDto;
import by.tms.rest.api.dto.conversion.ConversionUtils;
import by.tms.rest.api.repository.StudentRepository;
import by.tms.rest.api.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static by.tms.rest.api.dto.conversion.ConversionUtils.convertToStudent;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    @Override
    public List<StudentDto> getAllStudents() {
        return studentRepository.findAll().stream().map(ConversionUtils::convertToStudentDto).toList();
    }

    @Override
    public StudentDto getStudent(Long id) {
        Optional<Student> student = studentRepository.findById(id);
        return student.map(ConversionUtils::convertToStudentDto).orElse(null);
    }



    @Override
    public void addStudent(StudentDto studentDto) {
        Student student = convertToStudent(studentDto);
        studentRepository.save(student);
    }



    @Override
    public void updateStudent(Long id, StudentDto updatedStudent) {
        StudentDto studentDto = getStudent(id);
        if (studentDto != null) {
            updatedStudent.setId(id);
            studentRepository.save(convertToStudent(updatedStudent));
        }
    }

    @Override
    public void deleteStudent(Long id) {
        StudentDto studentDto = getStudent(id);
        if (studentDto != null) {
            studentRepository.delete(convertToStudent(studentDto));
        }
    }
}
