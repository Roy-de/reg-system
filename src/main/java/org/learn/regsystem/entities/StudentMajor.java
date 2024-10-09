package org.learn.regsystem.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "student_major")
@Getter
@Setter
@RequiredArgsConstructor
public class StudentMajor {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID student_id;
    private UUID major_id;
}
