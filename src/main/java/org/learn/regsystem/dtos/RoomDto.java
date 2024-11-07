package org.learn.regsystem.dtos;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@RequiredArgsConstructor
public class RoomDto {
    private Long roomId;
    private String roomNumber;
    private String roomType;
    private BuildingDto building;
    private Set<LecturerDto> lecturerDtos;
    private Set<LabDto> labDtos;
    private Set<OfficeDto> officeDtos;
}
