package org.learn.regsystem.repositories;

import org.learn.regsystem.entities.Day;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface DayRepository extends JpaRepository<Day, UUID> {
}