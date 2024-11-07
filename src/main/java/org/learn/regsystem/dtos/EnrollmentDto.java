package org.learn.regsystem.dtos;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class EnrollmentDto {
    private Long enrollmentId;
    private StudentDto studentDto;
    private CourseSectionDto courseSection;
}
