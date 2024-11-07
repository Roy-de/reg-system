package org.learn.regsystem.dtos;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
public class UsersDto {
    private Long userId;
    private String username;
    private String password;
    private StudentDto studentDto;
    private FacultyDto faculty;
    private AdminDto admin;
    private InstitutionalResearcherDto institutionalResearcherDto;
    private List<LoginDto> logins;
}
