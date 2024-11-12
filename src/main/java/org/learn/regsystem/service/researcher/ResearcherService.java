package org.learn.regsystem.service.researcher;

import org.learn.regsystem.dtos.InstitutionalResearcherDto;
import org.learn.regsystem.entities.InstitutionalResearcher;
import org.learn.regsystem.repositories.InstitutionalResearcherRepository;
import org.learn.regsystem.service.AbstractService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ResearcherService extends AbstractService<InstitutionalResearcher, InstitutionalResearcherDto, Long> {
    private final InstitutionalResearcherRepository researcherRepository;
    /**
     * Constructs an AbstractService with the specified repository.
     *
     * @param repository the JPA repository for the entity type.
     */
    protected ResearcherService(JpaRepository<InstitutionalResearcher, Long> repository, InstitutionalResearcherRepository researcherRepository) {
        super(repository);
        this.researcherRepository = researcherRepository;
    }

    @Override
    protected Class<InstitutionalResearcher> getEntityClass() {
        return InstitutionalResearcher.class;
    }
    public InstitutionalResearcher findByUserId(Long userId) {
        Optional<InstitutionalResearcher> researcher = researcherRepository.findByUsersUserId(userId);
        return researcher.orElse(null);
    }

    @Override
    public InstitutionalResearcher findByUsernameOrEmail(String username, String email) throws Exception {
        return null;
    }
}
