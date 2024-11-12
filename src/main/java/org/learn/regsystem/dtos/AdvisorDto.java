package org.learn.regsystem.dtos;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@RequiredArgsConstructor
public class AdvisorDto {
    private StudentDto student;
    private FacultyDto faculty;
    private LocalDate dateOfAppointment;
}