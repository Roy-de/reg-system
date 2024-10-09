package org.learn.regsystem.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "faculty_part_time")
@Getter
@Setter
@RequiredArgsConstructor
public class FacultyPartTime {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID faculty_id;
    private int minnoclasses;
    private int maxnoclasses;;
}