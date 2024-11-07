package org.learn.regsystem.dtos;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class GraduateFullTimeDto {
    private Long graduateFullTimeId;
    private GraduateDto graduateDto;
}
