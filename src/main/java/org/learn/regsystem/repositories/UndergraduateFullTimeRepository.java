package org.learn.regsystem.repositories;

import org.learn.regsystem.entities.UndergraduateFullTime;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UndergraduateFullTimeRepository extends JpaRepository<UndergraduateFullTime, UUID> {
}