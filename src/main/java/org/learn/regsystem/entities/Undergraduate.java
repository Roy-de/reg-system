package org.learn.regsystem.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "undergraduate")
@Getter
@Setter
@RequiredArgsConstructor
public class Undergraduate {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID student_id;
    private UUID dept_id;
    private String undergraduate_student_type;
}
