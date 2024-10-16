package org.learn.regsystem;

import org.learn.regsystem.entities.Login;
import org.learn.regsystem.repositories.LoginRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import java.util.UUID;

@SpringBootApplication
public class RegSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(RegSystemApplication.class, args);
    }
   /* @Component
    public class DefaultUserLoader implements CommandLineRunner {

        private final LoginRepository loginRepository;

        public DefaultUserLoader(LoginRepository loginRepository) {
            this.loginRepository = loginRepository;
        }

        @Override
        public void run(String... args) {
            createDefaultUsers();
        }

        private void createDefaultUsers() {
            Login login = new Login();
            login.setLogin_id(UUID.randomUUID());
            login.setEmail("nicolas@gmail.com");
            login.setPassword("123456");
            login.setUser_type("student");
            login.setNo_of_attempts(1);
            login.setLockout(false);
            // Save the default user to the database
            loginRepository.save(login);
        }
    }*/
}
