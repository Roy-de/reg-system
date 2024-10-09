package org.learn.regsystem.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "timeslot_day")
@Getter
@Setter
@RequiredArgsConstructor
public class TimeSlotDay {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID timeslotday_id;
    private UUID day_id;
    private String periods;
}
