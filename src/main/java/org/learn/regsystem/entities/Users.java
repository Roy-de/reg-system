package org.learn.regsystem.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "users")
@Getter
@Setter
@RequiredArgsConstructor
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID users_id;
    private String first_name;
    private String middle_name;
    private String last_name;
    private String gender;
    private LocalDate dob;
    private String house_no;
    private String street_name;
    private String city;
    private String state;
    private String zipcode;
    private String phone_no;
    private String user_type;
}
