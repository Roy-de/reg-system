package org.learn.regsystem.repositories;

import org.learn.regsystem.entities.Login;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LoginRepository extends JpaRepository<Login, Long> {
    Optional<Login> findByUsersUsername(String email);
}