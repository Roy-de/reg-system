package org.learn.regsystem.service.researcher;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.learn.regsystem.dtos.InstitutionalResearcherDto;
import org.learn.regsystem.dtos.UsersDto;
import org.learn.regsystem.entities.InstitutionalResearcher;
import org.learn.regsystem.entities.Users;
import org.learn.regsystem.repositories.InstitutionalResearcherRepository;
import org.learn.regsystem.repositories.UsersRepository;
import org.learn.regsystem.service.AbstractService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Optional;

@Service
public class ResearcherUserService extends AbstractService<Users, UsersDto, Long> {
    private final HttpServletRequest request;
    private final UsersRepository usersRepository;
    /**
     * Constructs an AbstractService with the specified repository.
     *
     * @param repository the JPA repository for the entity type.
     */
    protected ResearcherUserService(JpaRepository<Users, Long> repository, HttpServletRequest request, UsersRepository usersRepository) {
        super(repository);
        this.request = request;
        this.usersRepository = usersRepository;
    }

    @Override
    protected Class<Users> getEntityClass() {
        return Users.class;
    }

    @Override
    public Users findByUsernameOrEmail(String username, String email) throws Exception {
        return null;
    }

    @Override
    public Users login(UsersDto usersDto) throws Exception {
        Optional<Users> users = usersRepository.findByUsername(usersDto.getUsername());
        if (users.isPresent() && Objects.nonNull(users.get().getInstitutionalResearcher())){
            Users user = users.get();
            if(user.getPassword().equals(usersDto.getPassword())){
                Authentication auth = new UsernamePasswordAuthenticationToken(user, null, new ArrayList<>());
                SecurityContextHolder.getContext().setAuthentication(auth);
                HttpSession session = request.getSession();
                session.setAttribute("loggedInUser", user);
                return user;
            }else {
                return null;
            }
        }else {
            return null;
        }
    }
}
