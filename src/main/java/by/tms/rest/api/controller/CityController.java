package by.tms.rest.api.controller;

import static by.tms.rest.api.utils.ResponseUtils.CREATION_MESSAGE;
import static by.tms.rest.api.utils.ResponseUtils.DELETION_MESSAGE;
import static by.tms.rest.api.utils.ResponseUtils.UPDATE_MESSAGE;
import static by.tms.rest.api.utils.ResponseUtils.getSuccessResponse;

import by.tms.rest.api.dto.CityDto;
import by.tms.rest.api.model.MessageResponse;
import by.tms.rest.api.service.CityService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("city")
@RequiredArgsConstructor
public class CityController {

    private final CityService cityService;

    @GetMapping
    public ResponseEntity<List<CityDto>> getAll() {
        return ResponseEntity.ok(cityService.getAllCities());
    }

    @GetMapping("{id}")
    public ResponseEntity<CityDto> getOne(@PathVariable Long id) {
        return ResponseEntity.ok(cityService.getCity(id));
    }

    @PostMapping
    public ResponseEntity<MessageResponse> create(@RequestBody CityDto cityDto) {
        cityService.addCity(cityDto);
        return ResponseEntity.ok(getSuccessResponse(CREATION_MESSAGE, cityDto));
    }

    @PostMapping("{id}")
    public ResponseEntity<MessageResponse> update(@PathVariable Long id, @RequestBody CityDto cityDto) {
        cityService.updateCity(id, cityDto);
        return ResponseEntity.ok(getSuccessResponse(UPDATE_MESSAGE, cityDto));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<MessageResponse> delete(@PathVariable Long id) {
        cityService.deleteCity(id);
        return ResponseEntity.ok(getSuccessResponse(DELETION_MESSAGE, CityDto.builder().build()));
    }
}
