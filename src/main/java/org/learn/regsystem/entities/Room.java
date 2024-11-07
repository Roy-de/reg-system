package org.learn.regsystem.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "room")
@Getter
@Setter
@RequiredArgsConstructor
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "room_id")
    private Long roomId;
    private String roomNumber;
    private String roomType;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "building_id", referencedColumnName = "building_id")
    private Building building;

    // Many-to-many relationship with Lecturer
    @ManyToMany
    @JoinTable(
            name = "room_lecturer",
            joinColumns = @JoinColumn(name = "room_id"),
            inverseJoinColumns = @JoinColumn(name = "lecturer_id")
    )
    private Set<Lecturer> lecturers;

    // Many-to-many relationship with Lab
    @ManyToMany
    @JoinTable(
            name = "room_lab",
            joinColumns = @JoinColumn(name = "room_id"),
            inverseJoinColumns = @JoinColumn(name = "lab_id")
    )
    private Set<Lab> labs;

    // Many-to-many relationship with Office
    @ManyToMany
    @JoinTable(
            name = "room_office",
            joinColumns = @JoinColumn(name = "room_id"),
            inverseJoinColumns = @JoinColumn(name = "office_id")
    )
    private Set<Office> offices;
}
