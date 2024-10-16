package org.learn.regsystem.repositories;

import org.learn.regsystem.entities.Minor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface MinorRepository extends JpaRepository<Minor, UUID> {
}