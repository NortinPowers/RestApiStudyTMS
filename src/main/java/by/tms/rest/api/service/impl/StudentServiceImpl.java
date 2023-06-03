package by.tms.rest.api.service.impl;

import static by.tms.rest.api.utils.ObjectHandlerUtils.getIgnoreProperties;

import by.tms.rest.api.domain.City;
import by.tms.rest.api.domain.Student;
import by.tms.rest.api.dto.StudentDto;
import by.tms.rest.api.dto.conversion.Convector;
import by.tms.rest.api.exception.CityNotFoundException;
import by.tms.rest.api.exception.NotFoundException;
import by.tms.rest.api.repository.CityRepository;
import by.tms.rest.api.repository.StudentRepository;
import by.tms.rest.api.service.StudentService;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final CityRepository cityRepository;
    private final Convector convector;

    @Override
    public List<StudentDto> getAllStudents() {
        return studentRepository.findAll().stream()
                                .map(student -> convector.convertToStudentDto(student.getId(), student))
                                .toList();
    }

    @Override
    public StudentDto getStudent(Long id) {
        return convector.convertToStudentDto(id, studentRepository.findById(id).orElseThrow(NotFoundException::new));
    }

    @Override
    public void addStudent(StudentDto studentDto) {
        Student student = convector.convertToStudent(studentDto);
        student.setCity(cityRepository.findCityByName(studentDto.getCityName()).orElseThrow(CityNotFoundException::new));
        studentRepository.save(student);
    }

    @Override
    public void updateStudent(Long id, StudentDto updatedStudent) {
        StudentDto studentDto = getStudent(id);
        if (studentDto != null) {
            Optional<City> optionalCity = cityRepository.findCityByName(updatedStudent.getCityName());
            if (optionalCity.isPresent()) {
                BeanUtils.copyProperties(updatedStudent, studentDto, getIgnoreProperties(updatedStudent, "id"));
                Student student = convector.convertToStudent(id, studentDto);
                student.setCity(optionalCity.get());
                studentRepository.save(student);
            }
        }
    }

    @Override
    public void deleteStudent(Long id) {
        StudentDto studentDto = getStudent(id);
        if (studentDto != null) {
            studentRepository.delete(convector.convertToStudent(id, studentDto));
        }
    }

    @Override
    public StudentDto getStudentByNameAndSurname(String name, String surname) {
        Student student = studentRepository.findByNameIgnoreCaseAndSurnameIgnoreCase(name, surname).orElseThrow(NotFoundException::new);
        return convector.convertToStudentDto(student.getId(), student);
    }

    @Override
    public StudentDto getStudentByName(String name) {
        Student student = studentRepository.findByNameIgnoreCase(name).orElseThrow(NotFoundException::new);
        return convector.convertToStudentDto(student.getId(), student);
    }
}
