package com.limolearn.student.service;

import com.limolearn.common.mapper.StudentMapper;
import com.limolearn.student.dto.CreateStudentRequest;
import com.limolearn.student.dto.StudentResponse;
import com.limolearn.student.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository repository;
    private final StudentMapper mapper;

    public StudentServiceImpl(StudentRepository repository, StudentMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public StudentResponse registrarEstudiante(CreateStudentRequest request) {

        if(repository.existsByEmail(request.email())){
            throw new IllegalArgumentException("Email de usuario ya registrado");
        }

        var usuario = mapper.toEntity(request);
        usuario.setRegistrationDate(LocalDateTime.now());

        var usuarioGuardado = repository.save(usuario);
        return mapper.toResponse(usuarioGuardado);
    }
}
