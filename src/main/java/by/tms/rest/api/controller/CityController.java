package by.tms.rest.api.controller;

import by.tms.rest.api.dto.CityDto;
import by.tms.rest.api.service.CityService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static by.tms.rest.api.utils.ControllerUtils.throwExceptionWhenNull;

@RestController
@RequestMapping("city")
@RequiredArgsConstructor
public class CityController {

     private final CityService cityService;

    @GetMapping
    public List<CityDto> getAll() {
        return cityService.getAllCities();
    }

    @GetMapping("{id}")
    public CityDto getOne(@PathVariable Long id) {
        CityDto city = cityService.getCity(id);
        throwExceptionWhenNull(city);
        return city;
    }

    @PostMapping
    public List<CityDto> create(@RequestBody CityDto cityDto) {
        cityService.addCity(cityDto);
        return cityService.getAllCities();
    }

    @PostMapping("{id}")
    public List<CityDto> update(@PathVariable Long id, @RequestBody CityDto cityDto) {
        CityDto city = cityService.getCity(id);
        throwExceptionWhenNull(city);
        cityService.updateCity(id, cityDto);
        return cityService.getAllCities();
    }

    @DeleteMapping("{id}")
    public List<CityDto> delete(@PathVariable Long id) {
        throwExceptionWhenNull(cityService.getCity(id));
        cityService.deleteCity(id);
        return cityService.getAllCities();
    }
}
