package org.learn.regsystem.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "timeslot")
@Getter
@Setter
@RequiredArgsConstructor
public class TimeSlot {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID timeslot_id;
    private String days;
    private String periods;
}
