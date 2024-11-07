package org.learn.regsystem.dtos;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class StudentHistoryDto {
    private Long historyId;
    private StudentDto studentDto;
    private CourseDto course;

    private String grade;
}
