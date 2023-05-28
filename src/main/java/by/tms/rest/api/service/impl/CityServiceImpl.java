package by.tms.rest.api.service.impl;

import by.tms.rest.api.domain.City;
import by.tms.rest.api.dto.CityDto;
import by.tms.rest.api.dto.conversion.Convertor;
import by.tms.rest.api.exception.NotFoundException;
import by.tms.rest.api.repository.CityRepository;
import by.tms.rest.api.service.CityService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CityServiceImpl implements CityService {

    private final CityRepository cityRepository;
    private final Convertor convertor;

    @Override
    public List<CityDto> getAllCities() {
        return cityRepository.findAll().stream()
                             .map(convertor::convertToCityDto)
                             .toList();
    }

    @Override
    public CityDto getCity(Long id) {
        return convertor.convertToCityDto(cityRepository.findById(id).orElseThrow(NotFoundException::new));
    }


    @Override
    public void addCity(CityDto cityDto) {
        cityDto.setId(null);
        City city = convertor.convertToCity(cityDto);
        cityRepository.save(city);
    }


    @Override
    public void updateCity(Long id, CityDto updatedCity) {
        CityDto cityDto = getCity(id);
        if (cityDto != null) {
            updatedCity.setId(id);
            cityRepository.save(convertor.convertToCity(updatedCity));
        }
    }

    @Override
    public void deleteCity(Long id) {
        CityDto cityDto = getCity(id);
        if (cityDto != null) {
            cityRepository.delete(convertor.convertToCity(cityDto));
        }
    }
}
