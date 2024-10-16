package org.learn.regsystem.repositories;

import org.learn.regsystem.entities.MinorRequirements;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface MinorRequirementsRepository extends JpaRepository<MinorRequirements, UUID> {
}