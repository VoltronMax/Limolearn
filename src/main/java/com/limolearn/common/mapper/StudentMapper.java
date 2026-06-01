package com.limolearn.common.mapper;

import com.limolearn.student.dto.CreateStudentRequest;
import com.limolearn.student.dto.StudentResponse;
import com.limolearn.student.entity.Student;
import org.springframework.stereotype.Component;

@Component
public class StudentMapper {

    public Student toEntity(CreateStudentRequest request){

        Student student = new Student();
        student.setFirstName(request.firstName());
        student.setLastName(request.lastName());
        student.setEmail(request.email());
        student.setPasswordH(request.password());

        return student;
    }

    public StudentResponse toResponse(Student student){

        return new StudentResponse(
                student.getId(),
                student.getFirstName(),
                student.getLastName(),
                student.getEmail()
        );
    }
}
