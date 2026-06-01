package com.limolearn.student.controller;

import com.limolearn.student.dto.CreateStudentRequest;
import com.limolearn.student.dto.StudentResponse;
import com.limolearn.student.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/students")
public class StudentController {

    private final StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public StudentResponse registrarEstudiante(@Valid @RequestBody CreateStudentRequest request){
        return service.registrarEstudiante(request);
    }
}
