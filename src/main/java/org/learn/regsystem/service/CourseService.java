package org.learn.regsystem.service;

import org.learn.regsystem.dtos.CourseDto;
import org.learn.regsystem.entities.Course;
import org.learn.regsystem.repositories.CourseRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CourseService extends AbstractService<Course, CourseDto, UUID> {
    private final CourseRepository courseRepository;

    protected CourseService(CourseRepository repository, CourseRepository courseRepository) {
        super(repository);
        this.courseRepository = courseRepository;
    }

    @Override
    protected Class<Course> getEntityClass() {
        return Course.class;
    }

    public List<Course> searchByParameters(String courseName) {
        return courseRepository.findByCourse_name(courseName);
    }

    @Override
    public Course findByUsernameOrEmail(String username, String email) throws Exception {
        return null;
    }
}
