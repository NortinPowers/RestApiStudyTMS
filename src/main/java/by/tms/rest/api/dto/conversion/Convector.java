package by.tms.rest.api.dto.conversion;

import by.tms.rest.api.domain.City;
import by.tms.rest.api.domain.Student;
import by.tms.rest.api.dto.CityDto;
import by.tms.rest.api.dto.StudentDto;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class Convector {

    public CityDto convertToCityDto(City city) {
        CityDto cityDto = new CityDto();
        BeanUtils.copyProperties(city, cityDto, "id");
        return cityDto;
    }

    public CityDto convertToCityDto(Long id, City city) {
        CityDto cityDto = new CityDto();
        BeanUtils.copyProperties(city, cityDto, "id");
        cityDto.setId(id);
        return cityDto;
    }

    public City convertToCity(CityDto cityDto) {
        City city = new City();
        BeanUtils.copyProperties(cityDto, city, "id");
        return city;
    }

    public City convertToCity(Long id, CityDto cityDto) {
        City city = new City();
        BeanUtils.copyProperties(cityDto, city, "id");
        city.setId(id);
        return city;
    }

    public StudentDto convertToStudentDto(Student student) {
        StudentDto studentDto = new StudentDto();
        BeanUtils.copyProperties(student, studentDto, "id", "city");
        studentDto.setCityName(student.getCity().getName());
        return studentDto;
    }

    public StudentDto convertToStudentDto(Long id, Student student) {
        StudentDto studentDto = new StudentDto();
        BeanUtils.copyProperties(student, studentDto, "id", "city");
        studentDto.setCityName(student.getCity().getName());
        studentDto.setId(id);
        return studentDto;
    }

    public Student convertToStudent(StudentDto studentDto) {
        Student student = new Student();
        BeanUtils.copyProperties(studentDto, student, "id", "cityName");
        return student;
    }

    public Student convertToStudent(Long id, StudentDto studentDto) {
        Student student = new Student();
        BeanUtils.copyProperties(studentDto, student, "id", "cityName");
        student.setId(id);
        return student;
    }
}
