package org.learn.regsystem.dtos;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@RequiredArgsConstructor
public class StudentDto {
    private Long studentId;
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private UsersDto usersDto;
    private List<AttendanceDto> attendances;
    private MajorDto majorDto;
    private MinorDto minorDto;
    private Set<GraduateDto> graduateDtos;
    private List<StudentHoldDto> studentHoldDtos;
    private Set<UndergraduateDto> undergraduateDtos;
    private List<StudentHistoryDto> studentHistories;
    private List<EnrollmentDto> enrollments;
}
