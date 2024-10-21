package org.learn.regsystem.service;


import org.learn.regsystem.entities.Login;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    private final LoginService loginService;

    @Autowired
    public CustomUserDetailsService(LoginService loginService) {
        this.loginService = loginService;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        try{
            Login login = loginService.loginByEmail(email);
            if (login == null) {
                throw new UsernameNotFoundException("User not found");
            }
            return User.builder()
                    .username(login.getEmail())
                    .password("{noop}" + login.getPassword())
                    .roles("USER") // You can assign roles here
                    .build();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
