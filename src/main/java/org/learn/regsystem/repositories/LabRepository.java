package org.learn.regsystem.repositories;

import org.learn.regsystem.entities.Lab;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LabRepository extends JpaRepository<Lab, Long> {
}