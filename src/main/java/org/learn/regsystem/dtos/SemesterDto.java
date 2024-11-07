package org.learn.regsystem.dtos;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@RequiredArgsConstructor
public class SemesterDto {
    private Long semesterId;
    private String name;
    private LocalDate startDate;
    private LocalDate endDate;
    private CourseSectionDto courseSections;

}
