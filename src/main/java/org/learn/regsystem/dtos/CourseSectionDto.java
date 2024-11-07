package org.learn.regsystem.dtos;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class CourseSectionDto {
    private Long sectionId;
    private CourseDto course;
    private FacultyDto faculty;
    private SemesterDto semesterDto;
    private EnrollmentDto enrollments;
}
