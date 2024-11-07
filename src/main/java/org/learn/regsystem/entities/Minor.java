package org.learn.regsystem.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "minor")
@Getter
@Setter
@RequiredArgsConstructor
public class Minor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "minor_id")
    private Long minorId;
    private String name;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id", unique = true, nullable = false)
    private Department department;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "required_course_id", nullable = false)
    private Course requiredCourse;
}
