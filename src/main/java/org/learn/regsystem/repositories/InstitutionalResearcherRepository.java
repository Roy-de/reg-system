package org.learn.regsystem.repositories;

import org.learn.regsystem.entities.InstitutionalResearcher;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface InstitutionalResearcherRepository extends JpaRepository<InstitutionalResearcher, UUID> {
}