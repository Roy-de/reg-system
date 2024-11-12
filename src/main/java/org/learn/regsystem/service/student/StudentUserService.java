package org.learn.regsystem.service.student;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.learn.regsystem.dtos.UsersDto;
import org.learn.regsystem.entities.Users;
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
public class StudentUserService extends AbstractService<Users, UsersDto, Long> {

    private final HttpServletRequest request;

    private final UsersRepository usersRepository;
    protected StudentUserService(JpaRepository<Users, Long> repository, HttpServletRequest request, UsersRepository usersRepository) {
        super(repository);
        this.request = request;
        this.usersRepository = usersRepository;
    }


    @Override
    public Users findByUsernameOrEmail(String username, String email) {
        return null;
    }

    @Override
    protected Class<Users> getEntityClass() {
        return Users.class;
    }

    @Override
    public Users login(UsersDto usersDto) throws Exception {
        Optional<Users> users = usersRepository.findByUsername(usersDto.getUsername());
        if (users.isPresent() && Objects.nonNull(users.get().getStudent())){
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
