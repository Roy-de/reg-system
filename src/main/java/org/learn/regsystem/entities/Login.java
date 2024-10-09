package org.learn.regsystem.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "login")
@Getter
@Setter
@RequiredArgsConstructor
public class Login {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID login_id;
    private String email;
    private String password;
    private int no_of_attempts;
    private boolean lockout;
    private String user_type;
}
