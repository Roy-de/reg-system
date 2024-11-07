package org.learn.regsystem.repositories;

import org.learn.regsystem.entities.StudentHold;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentHoldRepository extends JpaRepository<StudentHold, Long> {
}