package by.tms.rest.api.dto.conversion;

import by.tms.rest.api.domain.Student;
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
                .city(student.getCity())
                .course(student.getCourse()).build();
    }

    public static Student convertToStudent(StudentDto studentDto) {
        return Student.builder()
                .id(studentDto.getId())
                .name(studentDto.getName())
                .surname(studentDto.getSurname())
                .age(studentDto.getAge())
                .city(studentDto.getCity())
                .course(studentDto.getCourse()).build();
    }
}
