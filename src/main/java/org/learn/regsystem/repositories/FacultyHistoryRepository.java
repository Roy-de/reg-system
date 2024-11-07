package org.learn.regsystem.repositories;

import org.learn.regsystem.entities.FacultyHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FacultyHistoryRepository extends JpaRepository<FacultyHistory, Long> {
}