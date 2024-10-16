package org.learn.regsystem.repositories;

import org.learn.regsystem.entities.UndergraduatePartTime;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UndergraduatePartTimeRepository extends JpaRepository<UndergraduatePartTime, UUID> {
}