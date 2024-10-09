package org.learn.regsystem.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "minor")
@Getter
@Setter
@RequiredArgsConstructor
public class Minor {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID minor_id;
    private String minor_name;
    private UUID dept_id;
    private double num_of_credits_required;
}
