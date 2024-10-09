package org.learn.regsystem.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "institutional_researcher")
@Getter
@Setter
@RequiredArgsConstructor
public class InstitutionalResearcher {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID institutionalResearcher_id;
    private String status;
}
