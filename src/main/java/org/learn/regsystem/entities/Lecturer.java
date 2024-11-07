package org.learn.regsystem.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "lecturer")
@Getter
@Setter
@RequiredArgsConstructor
public class Lecturer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "lecturer_id")
    private Long lecturerId;

    private String firstName;
    private String lastName;

    @ManyToMany(mappedBy = "lecturers")
    private Set<Room> rooms;
}
