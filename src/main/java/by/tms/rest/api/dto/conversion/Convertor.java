package by.tms.rest.api.dto.conversion;

import by.tms.rest.api.domain.City;
import by.tms.rest.api.domain.Student;
import by.tms.rest.api.dto.CityDto;
import by.tms.rest.api.dto.StudentDto;
import java.util.Objects;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Convertor {

    private final ModelMapper modelMapper;

    public CityDto convertToCityDto(City city) {
        return Objects.isNull(city) ? null : modelMapper.map(city, CityDto.class);
    }

    public City convertToCity(CityDto cityDto) {
        return Objects.isNull(cityDto) ? null : modelMapper.map(cityDto, City.class);
    }

    public StudentDto convertToStudentDto(Student student) {
        StudentDto studentDto;
        if (student != null) {
            String cityName = student.getCity().getName();
            studentDto = modelMapper.map(student, StudentDto.class);
            studentDto.setCityName(cityName);
        } else {
            studentDto = null;
        }
        return studentDto;
    }

    public Student convertToStudent(StudentDto studentDto) {
        return Objects.isNull(studentDto) ? null : modelMapper.map(studentDto, Student.class);
    }
}
