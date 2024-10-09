package org.learn.regsystem.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "hold")
@Getter
@Setter
@RequiredArgsConstructor
public class Hold {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID hold_id;
    private String hold_type;
}
