package org.learn.regsystem.dtos;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
public class HoldDto {
    private Long holdId;
    private String name;
    private String description;
    private List<StudentHoldDto> studentHoldDtos;
}
