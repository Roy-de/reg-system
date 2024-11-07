package org.learn.regsystem.repositories;

import org.learn.regsystem.entities.StudentHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentHistoryRepository extends JpaRepository<StudentHistory, Long> {
}