package org.learn.regsystem.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "student_history")
@Getter
@Setter
@RequiredArgsConstructor
public class StudentHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID student_id;
    private UUID crnno;
    private UUID course_id;
    private double grade;
    private UUID semester_id;
}
