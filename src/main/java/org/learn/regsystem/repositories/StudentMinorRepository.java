package org.learn.regsystem.repositories;

import org.learn.regsystem.entities.StudentMinor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface StudentMinorRepository extends JpaRepository<StudentMinor, UUID> {
}