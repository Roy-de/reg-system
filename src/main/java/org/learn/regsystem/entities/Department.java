package org.learn.regsystem.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "department")
@Getter
@Setter
@RequiredArgsConstructor
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID dept_id;
    private String dept_name;
    private int chair_id;
    private String dept_manager;
    private String email;
    private String phone;
    private UUID room_id;
}
