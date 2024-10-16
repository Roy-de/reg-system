package org.learn.regsystem.repositories;

import org.learn.regsystem.entities.Graduate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface GraduateRepository extends JpaRepository<Graduate, UUID> {
}
