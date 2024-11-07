package org.learn.regsystem.repositories;

import org.learn.regsystem.entities.Undergraduate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UndergraduateRepository extends JpaRepository<Undergraduate, Long> {
}