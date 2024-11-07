package org.learn.regsystem.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "graduate_part_time")
@Getter
@Setter
@RequiredArgsConstructor
public class GraduatePartTime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "graduate_part_time_id")
    private Long graduatePartTimeId;

    // Many-to-one relationship with Graduate
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "graduate_id", nullable = false)
    private Graduate graduate;
}
