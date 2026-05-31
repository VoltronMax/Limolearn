package com.limolearn.student.dto;


public record CreateStudentRequest (
        String firstName,
        String lastName,
        String email,
        String password

){
}
