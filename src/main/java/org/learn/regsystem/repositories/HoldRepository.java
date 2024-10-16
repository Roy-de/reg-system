package org.learn.regsystem.repositories;

import org.learn.regsystem.entities.Hold;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface HoldRepository extends JpaRepository<Hold, UUID> {
}