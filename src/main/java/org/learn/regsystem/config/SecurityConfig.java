package org.learn.regsystem.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    /*@Bean
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // In-memory authentication for demo purposes
        auth.inMemoryAuthentication()
                .withUser("user") // Create a user with username "user"
                .password("password") // Password is "password"
                .roles("USER"); // Assign role "USER"
    }*/
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http.cors(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(r -> r
                        .requestMatchers("/login", "/css/**", "/js/**").permitAll()
                        .anyRequest().permitAll())
                .formLogin(r -> r.loginPage("/login")
                        .defaultSuccessUrl("/home",true)
                        .failureForwardUrl("/login?error=true").permitAll())
                .logout(r -> r.logoutUrl("/logout")
                        .logoutSuccessUrl("/login?logout=true")
                        .permitAll()).build();
    }
}
