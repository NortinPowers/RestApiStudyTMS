package by.tms.rest.api.controller;

import static by.tms.rest.api.utils.ResponseUtils.CREATION_MESSAGE;
import static by.tms.rest.api.utils.ResponseUtils.DELETION_MESSAGE;
import static by.tms.rest.api.utils.ResponseUtils.UPDATE_MESSAGE;
import static by.tms.rest.api.utils.ResponseUtils.getSuccessResponse;

import by.tms.rest.api.dto.CityDto;
import by.tms.rest.api.exception.ExceptionResponse;
import by.tms.rest.api.model.MessageResponse;
import by.tms.rest.api.service.CityService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
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

@Tag(name = "City", description = "City management APIs")
@RestController
@RequestMapping("city")
@RequiredArgsConstructor
public class CityController {

    private final CityService cityService;

    @Operation(
            summary = "Retrieve a all Cities",
            description = "Collect all Cities. The answer is an array of Cities with an identifier, name and some information for each of the array element.",
            tags = "get")
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = {@Content(array = @ArraySchema(schema = @Schema(implementation = CityDto.class)), mediaType = "application/json")}),
            @ApiResponse(responseCode = "404", content = {@Content(schema = @Schema(implementation = ExceptionResponse.class), mediaType = "application/json")}),
            @ApiResponse(responseCode = "500", content = {@Content(schema = @Schema(implementation = ExceptionResponse.class), mediaType = "application/json")})})
    @GetMapping
    public ResponseEntity<List<CityDto>> getAll() {
        return ResponseEntity.ok(cityService.getAllCities());
    }

    @Operation(
            summary = "Retrieve a City by Id",
            description = "Get a City object by specifying its id. The response is City with identifier, name and some info.",
            tags = "get")
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = {@Content(schema = @Schema(implementation = CityDto.class), mediaType = "application/json")}),
            @ApiResponse(responseCode = "404", content = {@Content(schema = @Schema(implementation = ExceptionResponse.class), mediaType = "application/json")}),
            @ApiResponse(responseCode = "500", content = {@Content(schema = @Schema(implementation = ExceptionResponse.class), mediaType = "application/json")})})
    @GetMapping("{id}")
    public ResponseEntity<CityDto> getOne(@PathVariable Long id) {
        return ResponseEntity.ok(cityService.getCity(id));
    }

    @Operation(
            summary = "Create a new City",
            description = "Create a City. The response is a message about the successful creation of a City.",
            tags = "post")
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = {@Content(schema = @Schema(implementation = MessageResponse.class), mediaType = "application/json")}),
            @ApiResponse(responseCode = "404", content = {@Content(schema = @Schema(implementation = ExceptionResponse.class), mediaType = "application/json")}),
            @ApiResponse(responseCode = "500", content = {@Content(schema = @Schema(implementation = ExceptionResponse.class), mediaType = "application/json")})})
    @PostMapping
    public ResponseEntity<MessageResponse> create(@RequestBody CityDto cityDto) {
        cityService.addCity(cityDto);
        return ResponseEntity.ok(getSuccessResponse(CREATION_MESSAGE, cityDto));
    }

    @Operation(
            summary = "Update the City by Id",
            description = "Update the City by specifying its id. The response is a message about the successful update a City.",
            tags = "post")
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = {@Content(schema = @Schema(implementation = MessageResponse.class), mediaType = "application/json")}),
            @ApiResponse(responseCode = "404", content = {@Content(schema = @Schema(implementation = ExceptionResponse.class), mediaType = "application/json")}),
            @ApiResponse(responseCode = "500", content = {@Content(schema = @Schema(implementation = ExceptionResponse.class), mediaType = "application/json")})})
    @PostMapping("{id}")
    public ResponseEntity<MessageResponse> update(@PathVariable Long id, @RequestBody CityDto cityDto) {
        cityService.updateCity(id, cityDto);
        return ResponseEntity.ok(getSuccessResponse(UPDATE_MESSAGE, cityDto));
    }

    @Operation(
            summary = "Delete the City by Id",
            description = "Deletion the City by specifying its id. The response is a message about the successful deletion of a City.",
            tags = "delete")
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = {@Content(schema = @Schema(implementation = MessageResponse.class), mediaType = "application/json")}),
            @ApiResponse(responseCode = "404", content = {@Content(schema = @Schema(implementation = ExceptionResponse.class), mediaType = "application/json")}),
            @ApiResponse(responseCode = "500", content = {@Content(schema = @Schema(implementation = ExceptionResponse.class), mediaType = "application/json")})})
    @DeleteMapping("{id}")
    public ResponseEntity<MessageResponse> delete(@PathVariable Long id) {
        cityService.deleteCity(id);
        return ResponseEntity.ok(getSuccessResponse(DELETION_MESSAGE, CityDto.builder().build()));
    }
}
