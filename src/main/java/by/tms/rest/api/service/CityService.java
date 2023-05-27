package by.tms.rest.api.service;

import by.tms.rest.api.dto.CityDto;
import java.util.List;

public interface CityService {

    List<CityDto> getAllCities();

    CityDto getCity(Long id);

    void addCity(CityDto cityDto);

    void updateCity(Long id, CityDto cityDto);

    void deleteCity(Long id);
}
