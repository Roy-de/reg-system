package org.learn.regsystem.repositories;

import org.learn.regsystem.entities.FacultyHistory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface FacultyHistoryRepository extends JpaRepository<FacultyHistory, UUID> {
}