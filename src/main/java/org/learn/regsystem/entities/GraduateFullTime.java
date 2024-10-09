package org.learn.regsystem.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "graduate_full_time")
@Getter
@Setter
@RequiredArgsConstructor
public class GraduateFullTime {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID student_id;
    private int year;
    private int credits_earned;
    private boolean thesis;
}
