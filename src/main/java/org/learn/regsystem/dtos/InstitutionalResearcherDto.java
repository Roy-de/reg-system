package org.learn.regsystem.dtos;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@RequiredArgsConstructor
public class InstitutionalResearcherDto {
    private Long researcherId;
    private UsersDto usersDto;
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
}
