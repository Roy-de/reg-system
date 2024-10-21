package org.learn.regsystem.controllers.student;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.learn.regsystem.dtos.LoginDto;
import org.learn.regsystem.entities.Login;
import org.learn.regsystem.entities.Student;
import org.learn.regsystem.dtos.UserDto;
import org.learn.regsystem.entities.Users;
import org.learn.regsystem.service.LoginService;
import org.learn.regsystem.service.StudentService;
import org.learn.regsystem.service.UsersService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

@Controller
@Slf4j
@RequestMapping("/student")
public class StudentController {

    private final LoginService loginService;
    private final UsersService usersService;
    private final StudentService studentService;

    public StudentController(LoginService loginService, UsersService usersService, StudentService studentService) {
        this.loginService = loginService;
        this.usersService = usersService;
        this.studentService = studentService;
    }


    @GetMapping("/login")
    public String loginFrom(Model model) {
        model.addAttribute("LoginDto", new LoginDto());
        return "student/login";
    }

    @PostMapping("/login")
    public String loginTo(Model model,@ModelAttribute("LoginDto")LoginDto loginDto) throws Exception {
        Login login = loginService.login(loginDto);
        if (login != null && Objects.equals(login.getUser_type(), "Student")) {
            return "redirect:/student/dashboard";
        }else {
            model.addAttribute("loginError", "Invalid username or password.");
            return "student/login";
        }
    }
    @GetMapping("/dashboard")
    public String studentDashboard(Model model, Authentication authentication) throws Exception {
        User user = (User) authentication.getPrincipal();
        //String email = user.getUsername();
        //Login login = loginService.findByUsernameOrEmail(email,email);
        //Student student = studentService.findById(login.getLogin_id());

        //model.addAttribute("student", student);
        model.addAttribute("content", "student/dashboard");
        return "student/layout";
    }


    @GetMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
        if (authentication != null) {
            // Create a logout handler
            new SecurityContextLogoutHandler().logout(request, response, authentication);
        }
        return "redirect:/";  // Redirect to the home page or desired page after logout
    }
    @GetMapping("/profile")
    public String getProfile(Model model) {
        model.addAttribute("content", "student/profile");
        return "student/layout";
    }

    @GetMapping("/schedule")
    public String showSchedule(Model model) {
        model.addAttribute("content", "student/schedule.html");
        return "student/layout";
    }

    @GetMapping("/academics")
    public String showAcademics(Model model) {
        model.addAttribute("content", "student/academics.html");
        return "student/layout";
    }

    @GetMapping("/grades")
    public String showGrades(Model model) {
        model.addAttribute("content", "student/grades");
        return "student/layout";
    }

    @GetMapping("/holds")
    public String showHolds(Model model) {
        model.addAttribute("content", "student/holds");
        return "student/layout";
    }

    @GetMapping("/registration")
    public String showRegistration(Model model) {
        model.addAttribute("content", "student/registration");
        return "student/layout";
    }

    @GetMapping("/degree-audit")
    public String showDegreeAudit(Model model) {
        model.addAttribute("content", "student/degree-audit");
        return "student/layout";
    }

    @GetMapping("/unofficial-transcript")
    public String showUnofficialTranscript(Model model) {
        model.addAttribute("content", "student/unofficial-transcript");
        return "student/layout";
    }

    @GetMapping("/change-password")
    public String showChangePassword(Model model) {
        model.addAttribute("content", "student/change-password");
        return "student/layout";
    }
    @GetMapping("/search-schedule")
    public String showSearchSchedule(Model model) {
        model.addAttribute("content", "student/search-schedule");
        return "student/layout";
    }

    @GetMapping("/programs")
    public String showPrograms(Model model) {
        model.addAttribute("content", "student/programs");
        return "student/layout";
    }

    @GetMapping("/add-course")
    public String showAddCourse(Model model) {
        model.addAttribute("content", "student/add-course");
        return "student/layout";
    }

    @GetMapping("/remove-course")
    public String showRemoveCourse(Model model) {
        model.addAttribute("content", "student/remove-course");
        return "student/layout";
    }

    // Handling adding a course (POST request example)
    @PostMapping("/add-course")
    public String addCourse(@RequestParam String courseId, Model model) {
        // Example of how to handle course addition logic
        boolean courseAdded = true;  // replace with actual logic
        model.addAttribute("content", "student/add-course");
        if (courseAdded) {
            model.addAttribute("courseAdded", true);
        } else {
            model.addAttribute("errorMessage", "Failed to add course.");
        }
        return "student/layout";
    }

    // Handling removing a course (POST request example)
    @PostMapping("/remove-course")
    public String removeCourse(@RequestParam String courseId, Model model) {
        // Example of how to handle course removal logic
        boolean courseRemoved = true;  // replace with actual logic
        model.addAttribute("content", "student/remove-course");
        if (courseRemoved) {
            model.addAttribute("courseRemoved", true);
        } else {
            model.addAttribute("errorMessage", "Failed to remove course.");
        }
        return "student/layout";
    }
    @GetMapping("/profile/edit")
    public String editProfileForm(Model model) {
        // Simulating fetching the current user's data (this should come from the database)
        UserDto userDto = new UserDto();
        userDto.setFirst_name("");
        userDto.setMiddle_name("");
        userDto.setLast_name("");
        userDto.setGender("");
        userDto.setDob(LocalDate.parse("2022-01-01"));
        userDto.setHouse_no("");
        userDto.setStreet_name("");
        userDto.setCity("");
        userDto.setState("");
        userDto.setZipcode("");
        userDto.setPhone_no("");
        userDto.setUser_type("");

        // Add the student data to the model
        model.addAttribute("student", userDto);
        model.addAttribute("content", "student/profile-edit");
        return "student/layout";
    }

    @PostMapping("/profile/edit")
    public String updateProfile(
            @ModelAttribute("student") UserDto userDto,
            Model model
    ) {
        Users user = new Users();
        user.setFirst_name(userDto.getFirst_name());
        user.setMiddle_name(userDto.getMiddle_name());
        user.setLast_name(userDto.getLast_name());
        user.setGender(userDto.getGender());
        user.setDob(userDto.getDob());
        user.setHouse_no(userDto.getHouse_no());
        user.setStreet_name(userDto.getStreet_name());
        user.setCity(userDto.getCity());
        user.setState(userDto.getState());
        user.setZipcode(userDto.getZipcode());
        user.setPhone_no(userDto.getPhone_no());

        // Redirect back to the profile page after update
        return "redirect:/student/profile";
    }

}
