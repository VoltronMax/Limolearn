package com.limolearn.course.entity;

import com.limolearn.enrollment.entity.Enrollment;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "courses")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "course_seq")
    @SequenceGenerator(name = "course_seq",
            sequenceName = "course_seq",
            allocationSize = 50)
    private Long id;

    @NotBlank(message = "El curso debe tener un titulo")
    @Column(nullable = false, length = 256)
    private String title;

    @NotBlank(message = "El curso debe tener una descripcion")
    @Column(nullable = false)
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private CourseCategory category;

    @NotNull(message = "Se debe ingresar la duracion del curso en horas")
    @Positive(message = "El curso debe tener como minimo 1 hora de duracion")
    @Column(name = "duration_in_hours", nullable = false)
    private Integer durationInHours;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

    @OneToMany(mappedBy = "course")
    private List<Enrollment> enrollments;

}
