package org.learn.regsystem.dtos;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@RequiredArgsConstructor
public class GraduateDto {
    private Long graduateId;
    private Set<StudentDto> studentDtos;
    private Set<GraduateFullTimeDto> fullTimeRecords;
    private Set<GraduatePartTimeDto> partTimeRecords;
}
