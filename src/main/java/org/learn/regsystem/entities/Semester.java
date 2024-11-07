package org.learn.regsystem.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@RequiredArgsConstructor
@Entity
@Table(name = "semester")
public class Semester {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long semesterId;
    private String name;
    private LocalDate startDate;
    private LocalDate endDate;
    @OneToOne(mappedBy = "semester", cascade = CascadeType.ALL)
    private CourseSection courseSections;

}
