package org.learn.regsystem.service.student;

import org.learn.regsystem.dtos.UsersDto;
import org.learn.regsystem.entities.Users;
import org.learn.regsystem.repositories.UsersRepository;
import org.learn.regsystem.security.CustomAuthenticationToken;
import org.learn.regsystem.service.AbstractService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService extends AbstractService<Users, UsersDto,Long> {
    private final UsersRepository usersRepository;
    protected UserService(JpaRepository<Users, Long> repository, UsersRepository usersRepository) {
        super(repository);
        this.usersRepository = usersRepository;
    }


    @Override
    public Users findByUsernameOrEmail(String username, String email) throws Exception {
        return null;
    }

    @Override
    protected Class<Users> getEntityClass() {
        return Users.class;
    }

    @Override
    public Users login(UsersDto usersDto) throws Exception {
        Optional<Users> users = usersRepository.findByUsername(usersDto.getUsername());
        if (users.isPresent()) {
            Users user = users.get();
            if(user.getPassword().equals(usersDto.getPassword())){
                CustomAuthenticationToken auth = new CustomAuthenticationToken(user, null);
                auth.setAuthenticated(true);

                SecurityContextHolder.getContext().setAuthentication(auth);
                return user;
            }else {
                return null;
            }
        }else {
            return null;
        }
    }

    public Users getAuthenticatedUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication != null && authentication.isAuthenticated()) {
            if (authentication instanceof CustomAuthenticationToken) {
                return (Users) authentication.getPrincipal();
            }
        }
        return null;
    }

}
