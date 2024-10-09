package org.learn.regsystem.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "period")
@Getter
@Setter
@RequiredArgsConstructor
public class Period {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID period_is;
    private LocalDateTime start_time;
    private LocalDateTime end_time;
}
