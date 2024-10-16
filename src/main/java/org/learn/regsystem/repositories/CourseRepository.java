package org.learn.regsystem.repositories;

import org.learn.regsystem.entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface CourseRepository extends JpaRepository<Course, UUID> {
    @Query(value = "SELECT * from course c where c.course_name = ?1", nativeQuery = true)
    List<Course> findByCourse_name(String CourseName);
}
