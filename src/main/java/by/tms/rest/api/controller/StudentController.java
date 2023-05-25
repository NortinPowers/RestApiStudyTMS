package by.tms.rest.api.controller;

import static by.tms.rest.api.utils.ResponseUtils.CREATION_MESSAGE;
import static by.tms.rest.api.utils.ResponseUtils.DELETION_MESSAGE;
import static by.tms.rest.api.utils.ResponseUtils.UPDATE_MESSAGE;
import static by.tms.rest.api.utils.ResponseUtils.getSuccessResponse;

import by.tms.rest.api.dto.StudentDto;
import by.tms.rest.api.exception.ExceptionResponse;
import by.tms.rest.api.model.MessageResponse;
import by.tms.rest.api.service.StudentService;
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

@Tag(name = "Student", description = "Student management APIs")
@RestController
@RequestMapping("student")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @Operation(
            summary = "Retrieve a all Students",
            description = "Collect all Students. The answer is an array of Students with an identifier, name, surname, age, city name and course for each of the array element.",
            tags = "get")
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = {@Content(array = @ArraySchema(schema = @Schema(implementation = StudentDto.class)), mediaType = "application/json")}),
            @ApiResponse(responseCode = "404", content = {@Content(schema = @Schema(implementation = ExceptionResponse.class), mediaType = "application/json")}),
            @ApiResponse(responseCode = "500", content = {@Content(schema = @Schema(implementation = ExceptionResponse.class), mediaType = "application/json")})})
    @GetMapping
    public ResponseEntity<List<StudentDto>> getAll() {
        return ResponseEntity.ok(studentService.getAllStudents());
    }

    @Operation(
            summary = "Retrieve a Student by Id",
            description = "Get a Student object by specifying its id. The response is Student with an identifier, name, surname, age, city name and course.",
            tags = "get")
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = {@Content(schema = @Schema(implementation = StudentDto.class), mediaType = "application/json")}),
            @ApiResponse(responseCode = "404", content = {@Content(schema = @Schema(implementation = ExceptionResponse.class), mediaType = "application/json")}),
            @ApiResponse(responseCode = "500", content = {@Content(schema = @Schema(implementation = ExceptionResponse.class), mediaType = "application/json")})})
    @GetMapping("{id}")
    public ResponseEntity<StudentDto> getOne(@PathVariable Long id) {
        return ResponseEntity.ok(studentService.getStudent(id));
    }

    @Operation(
            summary = "Create a new Student",
            description = "Create a Student. The response is a message about the successful creation of a Student.",
            tags = "post")
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = {@Content(schema = @Schema(implementation = MessageResponse.class), mediaType = "application/json")}),
            @ApiResponse(responseCode = "404", content = {@Content(schema = @Schema(implementation = ExceptionResponse.class), mediaType = "application/json")}),
            @ApiResponse(responseCode = "500", content = {@Content(schema = @Schema(implementation = ExceptionResponse.class), mediaType = "application/json")})})
    @PostMapping
    public ResponseEntity<MessageResponse> create(@RequestBody StudentDto studentDto) {
        studentService.addStudent(studentDto);
        return ResponseEntity.ok(getSuccessResponse(CREATION_MESSAGE, studentDto));
    }

    @Operation(
            summary = "Update the Student by Id",
            description = "Update the Student by specifying its id. The response is a message about the successful update a Student.",
            tags = "post")
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = {@Content(schema = @Schema(implementation = MessageResponse.class), mediaType = "application/json")}),
            @ApiResponse(responseCode = "404", content = {@Content(schema = @Schema(implementation = ExceptionResponse.class), mediaType = "application/json")}),
            @ApiResponse(responseCode = "500", content = {@Content(schema = @Schema(implementation = ExceptionResponse.class), mediaType = "application/json")})})
    @PostMapping("{id}")
    public ResponseEntity<MessageResponse> update(@PathVariable Long id, @RequestBody StudentDto studentDto) {
        studentService.updateStudent(id, studentDto);
        return ResponseEntity.ok(getSuccessResponse(UPDATE_MESSAGE, studentDto));
    }

    @Operation(
            summary = "Delete the Student by Id",
            description = "Deletion the Student by specifying its id. The response is a message about the successful deletion of a Student.",
            tags = "delete")
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = {@Content(schema = @Schema(implementation = MessageResponse.class), mediaType = "application/json")}),
            @ApiResponse(responseCode = "404", content = {@Content(schema = @Schema(implementation = ExceptionResponse.class), mediaType = "application/json")}),
            @ApiResponse(responseCode = "500", content = {@Content(schema = @Schema(implementation = ExceptionResponse.class), mediaType = "application/json")})})
    @DeleteMapping("{id}")
    public ResponseEntity<MessageResponse> delete(@PathVariable Long id) {
        studentService.deleteStudent(id);
        return ResponseEntity.ok(getSuccessResponse(DELETION_MESSAGE, StudentDto.builder().build()));
    }

    @Operation(
            summary = "Retrieve a Student by Name and Surname",
            description = "Get a Student object by specifying its name and surname. The response is Student with an identifier, name, surname, age, city name and course.",
            tags = "get")
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = {@Content(schema = @Schema(implementation = StudentDto.class), mediaType = "application/json")}),
            @ApiResponse(responseCode = "404", content = {@Content(schema = @Schema(implementation = ExceptionResponse.class), mediaType = "application/json")}),
            @ApiResponse(responseCode = "500", content = {@Content(schema = @Schema(implementation = ExceptionResponse.class), mediaType = "application/json")})})
    @GetMapping("name/{name}/surname/{surname}")
    public ResponseEntity<StudentDto> getOneByNameAndSurname(@PathVariable String name, @PathVariable String surname) {
        return ResponseEntity.ok(studentService.getStudentByNameAndSurname(name, surname));
    }

    @Operation(
            summary = "Retrieve a Student by Name",
            description = "Get a Student object by specifying its name. The response is Student with an identifier, name, surname, age, city name and course.",
            tags = "get")
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = {@Content(schema = @Schema(implementation = StudentDto.class), mediaType = "application/json")}),
            @ApiResponse(responseCode = "404", content = {@Content(schema = @Schema(implementation = ExceptionResponse.class), mediaType = "application/json")}),
            @ApiResponse(responseCode = "500", content = {@Content(schema = @Schema(implementation = ExceptionResponse.class), mediaType = "application/json")})})
    @GetMapping("name/{name}")
    public ResponseEntity<StudentDto> getOneByNameAndSurname(@PathVariable String name) {
        return ResponseEntity.ok(studentService.getStudentByName(name));
    }
}
