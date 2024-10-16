package org.learn.regsystem.controllers.student;

import lombok.extern.slf4j.Slf4j;
import org.learn.regsystem.dtos.LoginDto;
import org.learn.regsystem.entities.Login;
import org.learn.regsystem.service.LoginService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Objects;

@Controller
@Slf4j
public class StudentController {

    private final LoginService loginService;

    public StudentController(LoginService loginService) {
        this.loginService = loginService;
    }


    @GetMapping("/student/login")
    public String loginFrom(Model model) {
        model.addAttribute("LoginDto", new LoginDto());
        return "student/login";
    }

    @PostMapping("/student/login")
    public String loginTo(Model model,@ModelAttribute("LoginDto")LoginDto loginDto) throws Exception {
        Login login = loginService.login(loginDto);
        if (login != null && Objects.equals(login.getUser_type(), "Student")) {
            return "redirect:/student/dashboard";
        }else {
            model.addAttribute("loginError", "Invalid username or password.");
            return "student/login";
        }
    }
    @GetMapping("/student/dashboard")
    public String studentDashboard() {
        return "student/dashboard";
    }
    @GetMapping("/logout")
    public String logout() {
        return "redirect:/student/login";
    }
}
