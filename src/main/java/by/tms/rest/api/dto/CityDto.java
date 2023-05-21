package by.tms.rest.api.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class CityDto {

    private Long id;
    private String name;
    private String info;
}
