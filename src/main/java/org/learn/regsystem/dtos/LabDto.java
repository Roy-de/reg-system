package org.learn.regsystem.dtos;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@RequiredArgsConstructor
public class LabDto {
    private Long labId;

    private String labName;
    private Set<RoomDto> roomDtos;
}
