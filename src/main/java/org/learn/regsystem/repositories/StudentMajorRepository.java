package org.learn.regsystem.repositories;

import org.learn.regsystem.entities.StudentMajor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface StudentMajorRepository extends JpaRepository<StudentMajor, UUID> {
}