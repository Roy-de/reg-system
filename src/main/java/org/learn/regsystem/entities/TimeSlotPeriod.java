package org.learn.regsystem.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "timeslot_period")
@Getter
@Setter
@RequiredArgsConstructor
public class TimeSlotPeriod {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID timeslot_period_id;
    private UUID period_id;
}
