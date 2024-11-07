package org.learn.regsystem.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "undergraduate")
@Getter
@Setter
@RequiredArgsConstructor
public class Undergraduate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "undergraduate_id")
    private Long undergraduateId;

    @ManyToMany(mappedBy = "undergraduates")
    private Set<Student> students;

    @OneToMany(mappedBy = "undergraduate", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<UndergraduatePartTime> partTimeRecords;

    @OneToMany(mappedBy = "undergraduate", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<UndergraduateFullTime> fullTimeRecords;
}
