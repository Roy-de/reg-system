package org.learn.regsystem.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "advisor")
@Getter
@Setter
@RequiredArgsConstructor
public class Advisor {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID faculty_id;
    private UUID student_id;
    private LocalDate date_of_appointment;
}
