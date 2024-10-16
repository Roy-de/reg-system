package org.learn.regsystem.dtos;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.UUID;


@Getter
@Setter
@RequiredArgsConstructor
public class StudentDto {
    private UUID student_id;
    private int student_year;
    private String student_type;
}
