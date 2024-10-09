package org.learn.regsystem.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "semester")
@Getter
@Setter
@RequiredArgsConstructor
public class Semester {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID semester_id;
    private String semester_name;
    private int semester_year;
    private LocalDate start_date;
    private LocalDate end_date;
}
