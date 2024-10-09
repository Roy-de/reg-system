package org.learn.regsystem.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "major_requirements")
@Getter
@Setter
@RequiredArgsConstructor
public class MajorRequirements {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID major_id;
    private UUID course_id;
    private double minimum_grade_required;
}
