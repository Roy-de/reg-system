package org.learn.regsystem.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http
                .authorizeHttpRequests(r -> r
                        .requestMatchers("/student/dashboard"
                                ,"/student/academics"
                                ,"student/grades"
                                ,"student/add-course"
                                ,"student/change-password"
                                ,"student/degree-audit"
                                ,"student/grades"
                                ,"student/holds"
                                ,"student/profile"
                                ,"student/profile/edit"
                                ,"student/programs"
                                ,"student/registration"
                                ,"student/remove-course"
                                ,"student/schedule"
                                ,"student/search-schedule"
                                ,"student/unofficial-transcript").authenticated()
                        .anyRequest().permitAll())
                .formLogin(c ->c
                        .loginPage("/student/login")
                        .usernameParameter("email")
                        .passwordParameter("password")
                        .defaultSuccessUrl("/student/dashboard")
                        .failureForwardUrl("/student/login")
                        .permitAll()
                )
                .logout(l->l
                        .logoutUrl("/logout")
                        .logoutSuccessUrl("/")
                        .invalidateHttpSession(true)
                        .clearAuthentication(true)
                        .deleteCookies("JSESSIONID")
                        .permitAll())
                .build();
    }
}
