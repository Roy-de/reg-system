package org.learn.regsystem.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "faculty_department")
@Getter
@Setter
@RequiredArgsConstructor
public class FacultyDepartment {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID faculty_dept_id;
    private UUID dept_id;
    private double percent_time;
    private LocalDate date_of_appointment;
}
