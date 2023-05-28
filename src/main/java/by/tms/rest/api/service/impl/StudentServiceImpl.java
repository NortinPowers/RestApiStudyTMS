package by.tms.rest.api.service.impl;

import by.tms.rest.api.domain.Student;
import by.tms.rest.api.dto.StudentDto;
import by.tms.rest.api.dto.conversion.Convertor;
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
    private final Convertor convertor;

    @Override
    public List<StudentDto> getAllStudents() {
        return studentRepository.findAll().stream()
                                .map(convertor::convertToStudentDto)
                                .toList();
    }

    @Override
    public StudentDto getStudent(Long id) {
        return convertor.convertToStudentDto(studentRepository.findById(id).orElseThrow(NotFoundException::new));
    }

    @Override
    public void addStudent(StudentDto studentDto) {
        studentDto.setId(null);
        Student student = convertor.convertToStudent(studentDto);
        student.setCity(cityRepository.findCityByName(studentDto.getCityName()).orElseThrow(NotFoundException::new));
        studentRepository.save(student);
    }


    @Override
    public void updateStudent(Long id, StudentDto updatedStudent) {
        StudentDto studentDto = getStudent(id);
        if (studentDto != null) {
            cityRepository.findCityByName(updatedStudent.getCityName()).orElseThrow(NotFoundException::new);
            updatedStudent.setId(id);
            studentRepository.save(convertor.convertToStudent(updatedStudent));
        }
    }

    @Override
    public void deleteStudent(Long id) {
        StudentDto studentDto = getStudent(id);
        if (studentDto != null) {
            studentRepository.delete(convertor.convertToStudent(studentDto));
        }
    }

    @Override
    public StudentDto getStudentByNameAndSurname(String name, String surname) {
        return convertor.convertToStudentDto(studentRepository.findByNameIgnoreCaseAndSurnameIgnoreCase(name, surname).orElseThrow(NotFoundException::new));
    }

    @Override
    public StudentDto getStudentByName(String name) {
        return convertor.convertToStudentDto(studentRepository.findByNameIgnoreCase(name).orElseThrow(NotFoundException::new));
    }
}
