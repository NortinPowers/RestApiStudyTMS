package by.tms.rest.api.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class StudentDto {

    private Long id;
    private String name;
    private String surname;
    private Integer age;
    private CityDto city;
    private String course;
}
