package org.learn.regsystem.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "admin")
@Getter
@Setter
@RequiredArgsConstructor
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID admin_id;

    private int security_level;

}
