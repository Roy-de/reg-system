package org.learn.regsystem.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "student_hold")
@Getter
@Setter
@RequiredArgsConstructor
public class StudentHold {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID student_id;
    private UUID hold_id;
    private LocalDate date_of_hold;
}
