package org.learn.regsystem.repositories;

import org.learn.regsystem.entities.Major;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MajorRepository extends JpaRepository<Major, Long> {
}