package org.learn.regsystem.repositories;

import org.learn.regsystem.entities.Period;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PeriodRepository extends JpaRepository<Period, UUID> {
}