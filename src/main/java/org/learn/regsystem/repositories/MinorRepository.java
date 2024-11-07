package org.learn.regsystem.repositories;

import org.learn.regsystem.entities.Minor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MinorRepository extends JpaRepository<Minor, Long> {
}