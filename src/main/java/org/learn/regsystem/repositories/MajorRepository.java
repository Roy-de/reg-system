package org.learn.regsystem.repositories;

import org.learn.regsystem.entities.Major;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface MajorRepository extends JpaRepository<Major, UUID> {
}