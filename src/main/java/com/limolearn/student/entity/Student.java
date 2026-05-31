package com.limolearn.student.entity;

import com.limolearn.enrollment.entity.Enrollment;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
    generator = "student_seq")
    @SequenceGenerator(name = "student_seq",
    sequenceName = "student_seq",
    allocationSize = 50)
    private Long id;

    @NotBlank(message = "El estudiante debe tener un nombre")
    @Column(name = "first_name", nullable = false, length = 100)
    private String firstName;

    @NotBlank(message = "El estudiante debe tener un apellido")
    @Column(name = "last_name", nullable = false, length = 100)
    private String lastName;

    @NotBlank(message = "El estudiante debe tener un correo")
    @Email
    @Column(unique = true, nullable = false)
    private String email;

    @NotBlank(message = "El estudiante debe tener una contrasena")
    @Column(name = "password_h",nullable = false)
    private String passwordH;

    @Column(name = "registration_date", nullable = false)
    private LocalDateTime registrationDate;

    @OneToMany(mappedBy = "student")
    private List<Enrollment> enrollments = new ArrayList<>();
}
