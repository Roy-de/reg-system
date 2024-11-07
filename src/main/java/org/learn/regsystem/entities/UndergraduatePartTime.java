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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "undergraduate_part_time_id")
    private Long undergraduatePartTimeId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "undergraduate_id", nullable = false)
    private Undergraduate undergraduate;
}
