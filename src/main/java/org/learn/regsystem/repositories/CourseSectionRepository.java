package org.learn.regsystem.repositories;

import org.learn.regsystem.entities.CourseSection;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CourseSectionRepository extends JpaRepository<CourseSection, UUID> {
}