package org.learn.regsystem.dtos;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@RequiredArgsConstructor
public class LecturerDto {
    private Long lecturerId;

    private String firstName;
    private String lastName;
    private Set<RoomDto> roomDtos;
}
