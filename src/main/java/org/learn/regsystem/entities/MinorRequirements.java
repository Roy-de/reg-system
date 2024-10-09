package org.learn.regsystem.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "minor_requirements")
@Getter
@Setter
@RequiredArgsConstructor
public class MinorRequirements {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID minor_id;
    private UUID course_id;
    private double minimum_grade_required;
}
