package org.learn.regsystem.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "building")
@Getter
@Setter
@RequiredArgsConstructor
public class Building {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID building_id;
    private String building_name;
    private String building_usage;
}
