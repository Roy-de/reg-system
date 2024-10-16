package org.learn.regsystem.dtos;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@RequiredArgsConstructor
public class LoginDto {
    private UUID login_id;
    private String email;
    private String password;
    private int no_of_attempts;
    private boolean lockout;
    private String user_type;
}
