package org.learn.regsystem.repositories;

import org.learn.regsystem.entities.InstitutionalResearcher;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface InstitutionalResearcherRepository extends JpaRepository<InstitutionalResearcher, Long> {
    Optional<InstitutionalResearcher> findByUsersUserId(Long userId);
}