package org.learn.regsystem.repositories;

import org.learn.regsystem.entities.Login;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface LoginRepository extends JpaRepository<Login, UUID> {
    Optional<Login> findByEmail(String username);
}