package org.learn.regsystem.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "undergraduate_full_time")
@Getter
@Setter
@RequiredArgsConstructor
public class UndergraduateFullTime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "undergraduate_full_time_id")
    private Long undergraduateFullTimeId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "undergraduate_id", nullable = false)
    private Undergraduate undergraduate;
}
