package org.learn.regsystem.service;

import org.learn.regsystem.dtos.LoginDto;
import org.learn.regsystem.entities.Login;
import org.learn.regsystem.repositories.LoginRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class LoginService extends AbstractService<Login, LoginDto, UUID> {
    private final LoginRepository loginRepository;

    protected LoginService(LoginRepository repository, LoginRepository loginRepository) {
        super(repository);
        this.loginRepository = loginRepository;
    }

    @Override
    protected Class<Login> getEntityClass() {
        return Login.class;
    }

    @Override
    public Login login(LoginDto loginDto) throws Exception {
        Optional<Login> user = loginRepository.findByEmail(loginDto.getEmail());
        if(user.isPresent()) {
            Login login = user.get();
            if(login.getPassword().equals(loginDto.getPassword())) {
                return login;
            }else{
                throw new Exception();
            }
        }else {
            return null;
        }
    }
}
