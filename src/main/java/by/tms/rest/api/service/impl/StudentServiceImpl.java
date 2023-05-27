package by.tms.rest.api.service.impl;

import static by.tms.rest.api.dto.conversion.ConversionUtils.convertToStudent;
import static by.tms.rest.api.dto.conversion.ConversionUtils.convertToStudentDto;

import by.tms.rest.api.domain.Student;
import by.tms.rest.api.dto.StudentDto;
import by.tms.rest.api.dto.conversion.ConversionUtils;
import by.tms.rest.api.exception.NotFoundException;
import by.tms.rest.api.repository.CityRepository;
import by.tms.rest.api.repository.StudentRepository;
import by.tms.rest.api.service.StudentService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final CityRepository cityRepository;

    @Override
    public List<StudentDto> getAllStudents() {
        return studentRepository.findAll().stream()
                                .map(ConversionUtils::convertToStudentDto)
                                .toList();
    }

    @Override
    public StudentDto getStudent(Long id) {
        return convertToStudentDto(studentRepository.findById(id).orElseThrow(NotFoundException::new));
    }

    @Override
    public void addStudent(StudentDto studentDto) {
        studentDto.setId(null);
        Student student = convertToStudent(studentDto);
        student.setCity(cityRepository.findCityByName(studentDto.getCityName()).orElseThrow(NotFoundException::new));
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

    @Override
    public StudentDto getStudentByNameAndSurname(String name, String surname) {
        return convertToStudentDto(studentRepository.findByNameIgnoreCaseAndSurnameIgnoreCase(name, surname).orElseThrow(NotFoundException::new));
    }

    @Override
    public StudentDto getStudentByName(String name) {
        return convertToStudentDto(studentRepository.findByNameIgnoreCase(name).orElseThrow(NotFoundException::new));
    }
}
