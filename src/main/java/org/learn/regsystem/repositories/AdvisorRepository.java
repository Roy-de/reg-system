package org.learn.regsystem.repositories;

import org.learn.regsystem.entities.Advisor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdvisorRepository extends JpaRepository<Advisor, Long> {
}