package org.learn.regsystem.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "course_section")
@Getter
@Setter
@RequiredArgsConstructor
public class CourseSection {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "section_id")
    private Long sectionId;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id", nullable = false) // Foreign key to Course
    private Course course;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "faculty_id", nullable = false) // Foreign key to Faculty
    private Faculty faculty;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "semester_id", nullable = false) // Foreign key to Semester
    private Semester semester;

    @OneToOne(mappedBy = "courseSection", cascade = CascadeType.ALL)
    private Enrollment enrollments;
}
