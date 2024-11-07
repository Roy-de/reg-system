package org.learn.regsystem.repositories;

import org.learn.regsystem.entities.Semester;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SemesterRepository extends JpaRepository<Semester, Long> {
}