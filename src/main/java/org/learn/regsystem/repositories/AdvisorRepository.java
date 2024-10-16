package org.learn.regsystem.repositories;

import org.learn.regsystem.entities.Advisor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AdvisorRepository extends JpaRepository<Advisor, UUID> {
}