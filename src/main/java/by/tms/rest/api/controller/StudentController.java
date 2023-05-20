package by.tms.rest.api.controller;

import by.tms.rest.api.dto.StudentDto;
import by.tms.rest.api.service.StudentService;
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
@RequestMapping("student")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @GetMapping
    public List<StudentDto> getAll() {
        return studentService.getAllStudents();
    }

    @GetMapping("{id}")
    public StudentDto getOne(@PathVariable Long id) {
        StudentDto student = studentService.getStudent(id);
        throwExceptionWhenNull(student);
        return student;
    }

    @PostMapping
    public List<StudentDto> create(@RequestBody StudentDto studentDto) {
        studentService.addStudent(studentDto);
        return studentService.getAllStudents();
    }

    @PostMapping("{id}")
    public List<StudentDto> update(@PathVariable Long id, @RequestBody StudentDto studentDto) {
        StudentDto student = studentService.getStudent(studentDto.getId());
        throwExceptionWhenNull(student);
        studentService.updateStudent(id, student);
        return studentService.getAllStudents();
    }

    @DeleteMapping("{id}")
    public List<StudentDto> delete(@PathVariable Long id) {
        throwExceptionWhenNull(studentService.getStudent(id));
        studentService.deleteStudent(id);
        return studentService.getAllStudents();
    }
}
