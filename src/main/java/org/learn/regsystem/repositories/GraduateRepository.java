package org.learn.regsystem.repositories;

import org.learn.regsystem.entities.Graduate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GraduateRepository extends JpaRepository<Graduate, Long> {
}