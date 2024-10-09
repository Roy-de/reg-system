package org.learn.regsystem.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "lab")
@Getter
@Setter
@RequiredArgsConstructor
public class Lab {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID lab_id;
    private UUID room_id;
    private int num_of_seats;
}
