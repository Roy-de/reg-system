package org.learn.regsystem.service.faculty;

import org.learn.regsystem.dtos.FacultyDto;
import org.learn.regsystem.entities.Faculty;
import org.learn.regsystem.repositories.FacultyRepository;
import org.learn.regsystem.service.AbstractService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class AdvisementService extends AbstractService<Faculty, FacultyDto, Long> {
    public final FacultyRepository facultyRepository;
    /**
     * Constructs an AbstractService with the specified repository.
     *
     * @param repository the JPA repository for the entity type.
     */
    protected AdvisementService(JpaRepository<Faculty, Long> repository, FacultyRepository facultyRepository) {
        super(repository);
        this.facultyRepository = facultyRepository;
    }

    @Override
    protected Class<Faculty> getEntityClass() {
        return Faculty.class;
    }

    @Override
    public Faculty findByUsernameOrEmail(String username, String email) throws Exception {
        return null;
    }
}
