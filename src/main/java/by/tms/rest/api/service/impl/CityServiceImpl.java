package by.tms.rest.api.service.impl;

import static by.tms.rest.api.utils.ObjectHandlerUtils.getIgnoreProperties;

import by.tms.rest.api.domain.City;
import by.tms.rest.api.dto.CityDto;
import by.tms.rest.api.dto.converter.CityConverter;
import by.tms.rest.api.exception.NotFoundException;
import by.tms.rest.api.repository.CityRepository;
import by.tms.rest.api.service.CityService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CityServiceImpl implements CityService {

    private final CityRepository cityRepository;
    private final CityConverter converter;

    @Override
    public List<CityDto> getAllCities() {
        return cityRepository.findAll().stream()
                             .map(city -> converter.convertToCityDto(city.getId(), city))
                             .toList();
    }

    @Override
    public CityDto getCity(Long id) {
        return converter.convertToCityDto(id, cityRepository.findById(id).orElseThrow(NotFoundException::new));
    }

    @Override
    public void addCity(CityDto cityDto) {
        City city = converter.convertToCity(cityDto);
        cityRepository.save(city);
    }

    @Override
    public void updateCity(Long id, CityDto updatedCity) {
        CityDto cityDto = getCity(id);
        if (cityDto != null) {
            BeanUtils.copyProperties(updatedCity, cityDto, getIgnoreProperties(updatedCity, "id"));
            cityRepository.save(converter.convertToCity(id, cityDto));
        }
    }

    @Override
    public void deleteCity(Long id) {
        CityDto cityDto = getCity(id);
        if (cityDto != null) {
            cityRepository.delete(converter.convertToCity(id, cityDto));
        }
    }
}
