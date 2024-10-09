package org.learn.regsystem.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "undergraduate_part_time")
@Getter
@Setter
@RequiredArgsConstructor
public class UndergraduatePartTime {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID student_id;
    private int year;
    private int min_credits;
    private int max_credits;
    private int credits_earned;
}
