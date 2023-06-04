package by.tms.rest.api.dto.converter;

import static by.tms.rest.api.utils.Constants.ModelField.ID;

import by.tms.rest.api.domain.City;
import by.tms.rest.api.dto.CityDto;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class CityConverter {

    public CityDto convertToCityDto(Long id, City city) {
        CityDto cityDto = new CityDto();
        BeanUtils.copyProperties(city, cityDto, ID);
        cityDto.setId(id);
        return cityDto;
    }

    public City convertToCity(CityDto cityDto) {
        City city = new City();
        BeanUtils.copyProperties(cityDto, city, ID);
        return city;
    }

    public City convertToCity(Long id, CityDto cityDto) {
        City city = new City();
        BeanUtils.copyProperties(cityDto, city, ID);
        city.setId(id);
        return city;
    }
}
