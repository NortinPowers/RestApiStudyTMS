package by.tms.rest.api.dto;

import by.tms.rest.api.domain.City;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class StudentDto {

    private Long id;
    private String name;
    private String surname;
    private Integer age;
    private City city;
    private String course;
}
