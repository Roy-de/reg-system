package org.learn.regsystem.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "major")
@Getter
@Setter
@RequiredArgsConstructor
public class Major {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID major_id;
    private UUID course_id;
    private double no_of_credits_required;
}
