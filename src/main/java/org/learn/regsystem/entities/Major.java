package org.learn.regsystem.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "major")
@Getter
@Setter
@RequiredArgsConstructor
public class Major {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "major_id")
    private Long majorId;
    private String name;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id", unique = true, nullable = false) // Foreign key column in Major table
    private Department department;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "required_course_id", nullable = false)
    private Course requiredCourse;
}
