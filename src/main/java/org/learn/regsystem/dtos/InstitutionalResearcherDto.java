package org.learn.regsystem.dtos;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class InstitutionalResearcherDto {
    private Long researcherId;
    private UsersDto usersDto;
}
