package org.learn.regsystem.dtos;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@RequiredArgsConstructor
public class LoginDto {
    private Long loginId;
    private UsersDto usersDto;
    private String role;
    private LocalDateTime loginTime;
}
