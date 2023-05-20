package by.tms.rest.api.dto;

import by.tms.rest.api.domain.Student;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class CityDto {

    private Long id;
    private String name;
    private String info;
    private List<Student> students;
}
