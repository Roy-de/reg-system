package org.learn.regsystem.repositories;

import org.learn.regsystem.entities.InstitutionalResearcher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InstitutionalResearcherRepository extends JpaRepository<InstitutionalResearcher, Long> {
}