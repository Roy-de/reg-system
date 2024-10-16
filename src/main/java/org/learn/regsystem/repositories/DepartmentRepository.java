package org.learn.regsystem.repositories;

import org.learn.regsystem.entities.Department;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface DepartmentRepository extends JpaRepository<Department, UUID> {
}