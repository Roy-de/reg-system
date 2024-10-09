package org.learn.regsystem.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "attendance")
@Getter
@Setter
@RequiredArgsConstructor
public class Attendance {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID student_id;
    private UUID crnno;
    private int course_id;
    private LocalDate class_date;
    private boolean present;
}
