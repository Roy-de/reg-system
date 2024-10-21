package org.learn.regsystem.service;

import org.learn.regsystem.dtos.UserDto;
import org.learn.regsystem.entities.Users;
import org.learn.regsystem.repositories.UsersRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UsersService extends AbstractService<Users, UserDto, UUID> {
    protected UsersService(UsersRepository repository) {
        super(repository);
    }

    @Override
    protected Class<Users> getEntityClass() {
        return Users.class;
    }

    @Override
    public Users findByUsernameOrEmail(String username, String email) throws Exception {
        return null;
    }
}
