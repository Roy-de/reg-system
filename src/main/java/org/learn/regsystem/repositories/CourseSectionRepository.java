package org.learn.regsystem.repositories;

import org.learn.regsystem.entities.CourseSection;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseSectionRepository extends JpaRepository<CourseSection, Long> {
}