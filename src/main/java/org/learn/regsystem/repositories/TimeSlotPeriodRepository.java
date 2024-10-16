package org.learn.regsystem.repositories;

import org.learn.regsystem.entities.TimeSlotPeriod;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TimeSlotPeriodRepository extends JpaRepository<TimeSlotPeriod, UUID> {
}