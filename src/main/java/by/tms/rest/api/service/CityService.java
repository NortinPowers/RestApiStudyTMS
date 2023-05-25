package by.tms.rest.api.service;

import by.tms.rest.api.dto.CityDto;
import java.util.List;

public interface CityService {

    List<CityDto> getAllCities();

    CityDto getCity(Long id);

    void addCity(CityDto student);

    void updateCity(Long id, CityDto updatedStudent);

    void deleteCity(Long id);
}
