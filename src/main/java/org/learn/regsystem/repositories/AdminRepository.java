package org.learn.regsystem.repositories;

import org.learn.regsystem.entities.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, Long> {
}