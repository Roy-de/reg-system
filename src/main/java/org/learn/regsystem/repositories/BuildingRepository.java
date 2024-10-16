package org.learn.regsystem.repositories;

import org.learn.regsystem.entities.Building;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BuildingRepository extends JpaRepository<Building, UUID> {
}