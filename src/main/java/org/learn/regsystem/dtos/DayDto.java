package org.learn.regsystem.dtos;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.Set;

@Data
@RequiredArgsConstructor
public class DayDto {
    private Long dayId;
    private String dayName;
    private Set<TimeSlotDto> timeSlotDtos;
}
