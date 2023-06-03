package by.tms.rest.api.dto.conversion;

import static by.tms.rest.api.utils.Constants.ModelField.CITY;
import static by.tms.rest.api.utils.Constants.ModelField.CITY_NAME;
import static by.tms.rest.api.utils.Constants.ModelField.ID;

import by.tms.rest.api.domain.City;
import by.tms.rest.api.domain.Student;
import by.tms.rest.api.dto.CityDto;
import by.tms.rest.api.dto.StudentDto;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class Convector {

    public CityDto convertToCityDto(Long id, City city) {
        CityDto cityDto = new CityDto();
        BeanUtils.copyProperties(city, cityDto, ID);
        cityDto.setId(id);
        return cityDto;
    }

    public City convertToCity(CityDto cityDto) {
        City city = new City();
        BeanUtils.copyProperties(cityDto, city, ID);
        return city;
    }

    public City convertToCity(Long id, CityDto cityDto) {
        City city = new City();
        BeanUtils.copyProperties(cityDto, city, ID);
        city.setId(id);
        return city;
    }

    public StudentDto convertToStudentDto(Long id, Student student) {
        StudentDto studentDto = new StudentDto();
        BeanUtils.copyProperties(student, studentDto, ID, CITY);
        studentDto.setCityName(student.getCity().getName());
        studentDto.setId(id);
        return studentDto;
    }

    public Student convertToStudent(StudentDto studentDto) {
        Student student = new Student();
        BeanUtils.copyProperties(studentDto, student, ID, CITY_NAME);
        return student;
    }

    public Student convertToStudent(Long id, StudentDto studentDto) {
        Student student = new Student();
        BeanUtils.copyProperties(studentDto, student, ID, CITY_NAME);
        student.setId(id);
        return student;
    }
}
