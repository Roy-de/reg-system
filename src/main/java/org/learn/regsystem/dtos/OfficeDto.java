package org.learn.regsystem.dtos;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@RequiredArgsConstructor
public class OfficeDto {
    private Long officeId;

    private String officeNumber;
    private Set<RoomDto> roomDtos;
}
