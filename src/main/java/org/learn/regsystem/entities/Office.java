package org.learn.regsystem.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "office")
@Getter
@Setter
@RequiredArgsConstructor
public class Office {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID office_id;
    private UUID room_id;
    private int no_of_desks;
}
