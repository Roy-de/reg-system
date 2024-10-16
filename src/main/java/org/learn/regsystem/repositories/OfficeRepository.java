package org.learn.regsystem.repositories;

import org.learn.regsystem.entities.Office;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface OfficeRepository extends JpaRepository<Office, UUID> {
}