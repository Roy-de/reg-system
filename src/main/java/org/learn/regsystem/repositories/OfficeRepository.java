package org.learn.regsystem.repositories;

import org.learn.regsystem.entities.Office;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OfficeRepository extends JpaRepository<Office, Long> {
}