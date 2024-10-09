package org.learn.regsystem.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "enrollment")
@Getter
@Setter
@RequiredArgsConstructor
public class Enrollment {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID student_id;
    private UUID crrno;
    private double grade;
    private LocalDate date_of_enrollment;
}
