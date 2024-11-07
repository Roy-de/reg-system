package org.learn.regsystem.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Data
@Entity
@Table(name = "timeslot")
public class TimeSlot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long timeSlotId;

    @ManyToMany(mappedBy = "timeSlots")
    private Set<Day> days;

    @ManyToMany(mappedBy = "timeSlots")
    private Set<Period> periods;
}
