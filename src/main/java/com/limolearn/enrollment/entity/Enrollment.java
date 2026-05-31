package com.limolearn.enrollment.entity;

import com.limolearn.course.entity.Course;
import com.limolearn.student.entity.Student;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "enrollments",
uniqueConstraints = {
        @UniqueConstraint(
                name = "uk_course_student",
                columnNames = {"student_id","course_id"}
        )
})
public class Enrollment {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "enrollment_seq")
    @SequenceGenerator(name = "enrollment_seq",
            sequenceName = "enrollment_seq",
            allocationSize = 50)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    private Student student;

    @Column(name = "enrollment_date", nullable = false)
    private LocalDateTime enrollmentDate;

    @ManyToOne
    @JoinColumn(name = "course_id", nullable = false)
    private Course course;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EnrollmentStatus status;
}
