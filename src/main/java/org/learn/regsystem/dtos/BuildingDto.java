package org.learn.regsystem.dtos;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class BuildingDto {
    private Long buildingId;
    private String name;
    private String location;
    private RoomDto roomDto;
}
