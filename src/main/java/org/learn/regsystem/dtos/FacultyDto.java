package org.learn.regsystem.dtos;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@RequiredArgsConstructor
public class FacultyDto {
    private Long facultyId;
    private String firstName;
    private String lastName;
    private UsersDto user;
    private Set<DepartmentDto> departmentDtos = new HashSet<>();
    private List<FacultyHistoryDto> facultyHistories;
    private List<FacultyPartTimeDto> partTimeFaculties;
    private List<FacultyFullTimeDto> fullTimeFaculties;
    private List<CourseSectionDto> courseSections;
    private AdvisorDto advisor;
}
