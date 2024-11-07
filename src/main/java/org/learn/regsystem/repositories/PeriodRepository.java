package org.learn.regsystem.repositories;

import org.learn.regsystem.entities.Period;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PeriodRepository extends JpaRepository<Period, Long> {
}