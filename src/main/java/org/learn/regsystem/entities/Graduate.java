package org.learn.regsystem.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "graduate")
@Getter
@Setter
@RequiredArgsConstructor
public class Graduate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "graduate_id")
    private Long graduateId;

    @ManyToMany(mappedBy = "graduates")
    private Set<Student> students;

    // One-to-many relationship with GraduateFullTime
    @OneToMany(mappedBy = "graduate", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<GraduateFullTime> fullTimeRecords;

    // One-to-many relationship with GraduatePartTime
    @OneToMany(mappedBy = "graduate", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<GraduatePartTime> partTimeRecords;
}
