package org.learn.regsystem.dtos;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;

@Data
@RequiredArgsConstructor
public class AttendanceDto {
    private Long attendanceId;
    private boolean present;
    private LocalDate date;
    private StudentDto studentDto;
}
