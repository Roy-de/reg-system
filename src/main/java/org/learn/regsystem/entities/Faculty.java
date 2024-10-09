package org.learn.regsystem.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "faculty")
@Getter
@Setter
@RequiredArgsConstructor
public class Faculty {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID faculty_id;
    private String specialty;
    private String faculty_rank;
    private String faculty_type;
}
