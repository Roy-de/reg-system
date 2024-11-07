package org.learn.regsystem.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@RequiredArgsConstructor
@Table(name = "hold")
public class Hold {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hold_id")
    private Long holdId;
    private String name;
    private String description;

    @OneToMany(mappedBy = "hold", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<StudentHold> studentHolds;
}
