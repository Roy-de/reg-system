package org.learn.regsystem.repositories;

import org.learn.regsystem.entities.CoursePrerequisites;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CoursePrerequisitesRepository extends JpaRepository<CoursePrerequisites, UUID> {
}
