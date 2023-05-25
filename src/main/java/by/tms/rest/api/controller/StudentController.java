package by.tms.rest.api.controller;

import static by.tms.rest.api.utils.ResponseUtils.CREATION_MESSAGE;
import static by.tms.rest.api.utils.ResponseUtils.DELETION_MESSAGE;
import static by.tms.rest.api.utils.ResponseUtils.UPDATE_MESSAGE;
import static by.tms.rest.api.utils.ResponseUtils.getSuccessResponse;

import by.tms.rest.api.dto.StudentDto;
import by.tms.rest.api.model.MessageResponse;
import by.tms.rest.api.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("student")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @GetMapping
    public ResponseEntity<List<StudentDto>> getAll() {
        return ResponseEntity.ok(studentService.getAllStudents());
    }

    @GetMapping("{id}")
    public ResponseEntity<StudentDto> getOne(@PathVariable Long id) {
        return ResponseEntity.ok(studentService.getStudent(id));
    }

    @PostMapping
    public ResponseEntity<MessageResponse> create(@RequestBody StudentDto studentDto) {
        studentService.addStudent(studentDto);
        return ResponseEntity.ok(getSuccessResponse(CREATION_MESSAGE, studentDto));
    }

    @PostMapping("{id}")
    public ResponseEntity<MessageResponse> update(@PathVariable Long id, @RequestBody StudentDto studentDto) {
        studentService.updateStudent(id, studentDto);
        return ResponseEntity.ok(getSuccessResponse(UPDATE_MESSAGE, studentDto));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<MessageResponse> delete(@PathVariable Long id) {
        studentService.deleteStudent(id);
        return ResponseEntity.ok(getSuccessResponse(DELETION_MESSAGE, StudentDto.builder().build()));
    }

    @GetMapping("name/{name}/surname/{surname}")
    public ResponseEntity<StudentDto> getOneByNameAndSurname(@PathVariable String name, @PathVariable String surname) {
        return ResponseEntity.ok(studentService.getStudentByNameAndSurname(name, surname));
    }

    @GetMapping("name/{name}")
    public ResponseEntity<StudentDto> getOneByNameAndSurname(@PathVariable String name) {
        return ResponseEntity.ok(studentService.getStudentByName(name));
    }
}
