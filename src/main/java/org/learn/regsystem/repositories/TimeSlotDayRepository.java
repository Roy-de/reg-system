package org.learn.regsystem.repositories;

import org.learn.regsystem.entities.TimeSlotDay;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TimeSlotDayRepository extends JpaRepository<TimeSlotDay, UUID> {
}