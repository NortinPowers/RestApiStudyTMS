package by.tms.rest.api.dto;

import static by.tms.rest.api.utils.Constants.CITY_NAMES_VALIDATION_PATTERN;
import static by.tms.rest.api.utils.Constants.STUDENT_NAMES_VALIDATION_PATTERN;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@Schema(description = "Entity of Student")
public class StudentDto {

    @Schema(description = "Identifier", example = "1")
    @Min(1)
    private Long id;
    @Schema(description = "Student`s name", example = "Martin")
    @NotBlank(message = "The 'name' field is required")
    @Pattern(regexp = STUDENT_NAMES_VALIDATION_PATTERN, message = "Incorrect student`s name")
    private String name;
    @Schema(description = "Student`s surname", example = "Blake")
    @NotBlank(message = "The 'surname' field is required")
    @Pattern(regexp = STUDENT_NAMES_VALIDATION_PATTERN, message = "Incorrect student`s surname")
    private String surname;
    @Schema(description = "Student`s age", example = "30")
    @Min(value = 3, message = "Incorrect student`s age")
    private Integer age;
    @Schema(description = "Student's city of residence", example = "New York")
    @NotBlank(message = "The 'cityName' field is required")
    @Pattern(regexp = CITY_NAMES_VALIDATION_PATTERN, message = "Incorrect city`s name")
    private String cityName;
    @Schema(description = "Student`s course", example = "22onlTMS")
    @NotBlank
    @Pattern(regexp = "[\\D\\d]{1,40}", message = "Incorrect student`s course")
    private String course;
}
