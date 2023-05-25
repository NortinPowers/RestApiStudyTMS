package by.tms.rest.api.dto.conversion;

import by.tms.rest.api.domain.City;
import by.tms.rest.api.domain.Student;
import by.tms.rest.api.dto.CityDto;
import by.tms.rest.api.dto.StudentDto;
import lombok.experimental.UtilityClass;

@UtilityClass
public class ConversionUtils {


    public static StudentDto convertToStudentDto(Student student) {
        return StudentDto.builder()
                         .id(student.getId())
                         .name(student.getName())
                         .surname(student.getSurname())
                         .age(student.getAge())
                         .city(convertToCityDto(student.getCity()))
                         .course(student.getCourse())
                         .build();
    }

    public static Student convertToStudent(StudentDto studentDto) {
        return Student.builder()
                      .id(studentDto.getId())
                      .name(studentDto.getName())
                      .surname(studentDto.getSurname())
                      .age(studentDto.getAge())
                      .city(convertToCity(studentDto.getCity()))
                      .course(studentDto.getCourse())
                      .build();
    }

    public static CityDto convertToCityDto(City city) {
        return CityDto.builder()
                      .id(city.getId())
                      .name(city.getName())
                      .info(city.getInfo())
                      .build();
    }

    public static City convertToCity(CityDto cityDto) {
        return City.builder()
                   .id(cityDto.getId())
                   .name(cityDto.getName())
                   .info(cityDto.getInfo())
                   .build();
    }
}
