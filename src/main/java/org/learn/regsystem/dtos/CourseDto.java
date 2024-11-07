package org.learn.regsystem.dtos;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
public class CourseDto {
    private Long courseId;
    private String courseName;
    private int credits;
    private DepartmentDto departmentDto;
    private List<MajorDto> majorDtos;
    private List<MinorDto> minorDtos;
    private List<StudentHistoryDto> studentHistories;
    private List<FacultyHistoryDto> facultyHistories;
    private CourseSectionDto courseSection;
    private List<CoursePrerequisitesDto> prerequisites;
}
