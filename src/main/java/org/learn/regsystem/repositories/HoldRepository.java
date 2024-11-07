package org.learn.regsystem.repositories;

import org.learn.regsystem.entities.Hold;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HoldRepository extends JpaRepository<Hold, Long> {
}