package org.learn.regsystem.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
@Table(name = "Users")
@Entity
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;
    private String username;
    private String password;

    @OneToOne(mappedBy = "users")
    private Student student;

    @OneToOne(mappedBy = "user")
    private Faculty faculty;

    @OneToOne(mappedBy = "users")
    private Admin admin;

    @OneToOne(mappedBy = "users")
    private InstitutionalResearcher institutionalResearcher;

    @OneToMany(mappedBy = "users", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Login> logins;
}
