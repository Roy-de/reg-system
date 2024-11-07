package org.learn.regsystem.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.Set;

@Data
@Entity
@Table(name = "period")
@RequiredArgsConstructor
public class Period {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long periodId;
    private String periodName;

    @ManyToMany
    @JoinTable(
            name = "period_timeslot",
            joinColumns = @JoinColumn(name = "period_id"),
            inverseJoinColumns = @JoinColumn(name = "time_slot_id")
    )
    private Set<TimeSlot> timeSlots;
}
