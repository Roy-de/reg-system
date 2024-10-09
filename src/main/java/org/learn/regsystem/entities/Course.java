package org.learn.regsystem.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "course")
@Getter
@Setter
@RequiredArgsConstructor
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID course_id;
    private String course_name;
    private int dept_id;
    private int no_of_credits;
    private String description;
    private String course_level;
}
