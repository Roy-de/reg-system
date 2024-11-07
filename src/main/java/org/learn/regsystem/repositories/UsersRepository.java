package org.learn.regsystem.repositories;

import org.learn.regsystem.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UsersRepository extends JpaRepository<Users, Long> {
    @Query("select u from Users u where u.username = ?1")
    Optional<Users> findByUsername(String username);
}