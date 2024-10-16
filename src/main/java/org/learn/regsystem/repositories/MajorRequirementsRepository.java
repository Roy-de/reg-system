package org.learn.regsystem.repositories;

import org.learn.regsystem.entities.MajorRequirements;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface MajorRequirementsRepository extends JpaRepository<MajorRequirements, UUID> {
}