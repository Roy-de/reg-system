package org.learn.regsystem.dtos;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.Set;

@Data
@RequiredArgsConstructor
public class PeriodDto {
    private Long periodId;
    private String periodName;
    private Set<TimeSlotDto> timeSlotDtos;
}
