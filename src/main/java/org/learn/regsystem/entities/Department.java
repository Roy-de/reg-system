package org.learn.regsystem.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "department")
@RequiredArgsConstructor
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "department_id")
    private Long departmentId;
    private String name;
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(
            name = "department_faculty",
            joinColumns = @JoinColumn(name = "department_id"),
            inverseJoinColumns = @JoinColumn(name = "faculty_id")
    )
    private Set<Faculty> faculties = new HashSet<>();

    @OneToOne(mappedBy = "department", cascade = CascadeType.ALL)
    private Course course;
    @OneToOne(mappedBy = "department", cascade = CascadeType.ALL)
    private Major major;
    @OneToOne(mappedBy = "department", cascade = CascadeType.ALL)
    private Major minor;
}
