package org.learn.regsystem.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "day")
@Getter
@Setter
@RequiredArgsConstructor
public class Day {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID day_id;
    private String weekday;
}
