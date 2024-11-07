package org.learn.regsystem.dtos;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class MajorDto {
    private Long majorId;
    private String name;
    private DepartmentDto departmentDto;
    private CourseDto requiredCourse;
}
