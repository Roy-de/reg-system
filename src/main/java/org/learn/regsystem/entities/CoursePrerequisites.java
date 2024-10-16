package org.learn.regsystem.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.UUID;


@Entity
@Table(name = "course_prerequisites")
@Getter
@Setter
@RequiredArgsConstructor
public class CoursePrerequisites {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID course_id;
    private UUID prerequisites_course_id;
    private int minimum_grade;
}
