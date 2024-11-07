package org.learn.regsystem.dtos;

import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@RequiredArgsConstructor
public class DepartmentDto {
    private Long departmentId;
    private String name;
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(
            name = "department_faculty",
            joinColumns = @JoinColumn(name = "department_id"),
            inverseJoinColumns = @JoinColumn(name = "faculty_id")
    )
    private Set<FacultyDto> faculties = new HashSet<>();

    @OneToOne(mappedBy = "department", cascade = CascadeType.ALL)
    private CourseDto course;
    @OneToOne(mappedBy = "department", cascade = CascadeType.ALL)
    private MajorDto majorDto;
    @OneToOne(mappedBy = "department", cascade = CascadeType.ALL)
    private MajorDto minor;
}
