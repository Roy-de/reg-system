package org.learn.regsystem.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Entity
@Table(name = "building")
@RequiredArgsConstructor
public class Building {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "building_id")
    private Long buildingId;
    private String name;
    private String location;

    @OneToOne(mappedBy = "building", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Room room;
}
