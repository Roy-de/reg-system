package org.learn.regsystem.dtos;

import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.Set;

@Data
@RequiredArgsConstructor
public class TimeSlotDto {
    private Long timeSlotId;
    private Set<DayDto> days;
    private Set<PeriodDto> periodDtos;
}
