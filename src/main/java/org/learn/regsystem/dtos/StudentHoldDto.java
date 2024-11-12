package org.learn.regsystem.dtos;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class StudentHoldDto {
    private Long studentHoldId;
    private StudentDto studentDto;
    private HoldDto holdDto;
}