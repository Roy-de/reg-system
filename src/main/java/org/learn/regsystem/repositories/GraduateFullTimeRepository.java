package org.learn.regsystem.repositories;

import org.learn.regsystem.entities.GraduateFullTime;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface GraduateFullTimeRepository extends JpaRepository<GraduateFullTime, UUID> {
}