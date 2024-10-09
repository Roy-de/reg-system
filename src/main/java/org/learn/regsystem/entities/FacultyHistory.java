package org.learn.regsystem.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "faculty_history")
@Getter
@Setter
@RequiredArgsConstructor
public class FacultyHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID faculty_id;
    private UUID crnno;
    private UUID course_id;
    private UUID semester_id;
}
