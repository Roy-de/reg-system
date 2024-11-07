package org.learn.regsystem.dtos;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@Getter
@Setter
@RequiredArgsConstructor
public class UndergraduateDto {
    private Long undergraduateId;
    private Set<StudentDto> studentDtos;
    private List<UndergraduatePartTimeDto> partTimeRecords;
    private List<UndergraduateFullTimeDto> fullTimeRecords;
}
