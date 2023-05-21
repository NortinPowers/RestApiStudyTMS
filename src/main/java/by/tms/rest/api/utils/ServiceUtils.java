package by.tms.rest.api.utils;

import by.tms.rest.api.domain.Student;
import by.tms.rest.api.dto.StudentDto;
import by.tms.rest.api.dto.conversion.ConversionUtils;
import lombok.experimental.UtilityClass;

import java.util.Optional;

@UtilityClass
public class ServiceUtils {

    public static StudentDto getStudentDto(Optional<Student> student) {
        return student.map(ConversionUtils::convertToStudentDto).orElse(null);
    }
}
