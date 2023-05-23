package by.tms.rest.api.service.impl;

import by.tms.rest.api.domain.City;
import by.tms.rest.api.dto.CityDto;
import by.tms.rest.api.dto.conversion.ConversionUtils;
import by.tms.rest.api.exception.NotFoundException;
import by.tms.rest.api.repository.CityRepository;
import by.tms.rest.api.service.CityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static by.tms.rest.api.dto.conversion.ConversionUtils.convertToCity;
import static by.tms.rest.api.dto.conversion.ConversionUtils.convertToCityDto;

@Service
@RequiredArgsConstructor
public class CityServiceImpl implements CityService {

    private final CityRepository cityRepository;

    @Override
    public List<CityDto> getAllCities() {
        return cityRepository.findAll().stream().map(ConversionUtils::convertToCityDto).toList();
    }

    @Override
    public CityDto getCity(Long id) {
        return convertToCityDto(cityRepository.findById(id).orElseThrow(NotFoundException::new));
    }


    @Override
    public void addCity(CityDto cityDto) {
        City city = convertToCity(cityDto);
        cityRepository.save(city);
    }


    @Override
    public void updateCity(Long id, CityDto updatedCity) {
        CityDto cityDto = getCity(id);
        if (cityDto != null) {
            updatedCity.setId(id);
            cityRepository.save(convertToCity(updatedCity));
        }
    }

    @Override
    public void deleteCity(Long id) {
        CityDto cityDto = getCity(id);
        if (cityDto != null) {
            cityRepository.delete(convertToCity(cityDto));
        }
    }
}
