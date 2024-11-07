package org.learn.regsystem.repositories;

import org.learn.regsystem.entities.Day;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DayRepository extends JpaRepository<Day, Long> {
}