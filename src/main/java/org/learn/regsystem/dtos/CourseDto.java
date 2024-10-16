package org.learn.regsystem.dtos;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@RequiredArgsConstructor
public class CourseDto {
    private UUID course_id;
    private String course_name;
    private UUID dept_id;
    private int no_of_credits;
    private String description;
    private String course_level;
}
