package org.learn.regsystem.dtos;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class MinorDto {
    private Long minorId;
    private String name;
    private DepartmentDto departmentDto;
    private CourseDto requiredCourse;
}
