package org.learn.regsystem.repositories;

import org.learn.regsystem.entities.FacultyFullTime;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface FacultyFullTimeRepository extends JpaRepository<FacultyFullTime, UUID> {
}