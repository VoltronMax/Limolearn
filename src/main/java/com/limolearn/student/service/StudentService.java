package com.limolearn.student.service;


import com.limolearn.student.dto.CreateStudentRequest;
import com.limolearn.student.dto.StudentResponse;

public interface StudentService {

    StudentResponse registrarEstudiante(CreateStudentRequest request);
}
