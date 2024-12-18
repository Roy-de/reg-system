package org.learn.regsystem.controllers.student;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.learn.regsystem.dtos.UsersDto;
import org.learn.regsystem.entities.Student;
import org.learn.regsystem.entities.Users;
import org.learn.regsystem.service.student.StudentUserService;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Controller
@Slf4j
@RequestMapping("/student")
public class StudentController {

    private final StudentUserService userService;
    private final HttpServletRequest request;

    public StudentController(StudentUserService userService, HttpServletRequest request) {
        this.userService = userService;
        this.request = request;
    }


    @GetMapping("/login")
    public String loginFrom(Model model) {
        model.addAttribute("userDto", new UsersDto());
        return "student/login";
    }

    @PostMapping("/login")
    public String loginTo(Model model,@ModelAttribute("userDto")UsersDto usersDto) throws Exception {
        Users users = userService.login(usersDto);
        if (users != null) {
            HttpSession session = request.getSession();
            session.setAttribute("userId", users.getUserId());
            return "redirect:/student/dashboard";
        }else {
            model.addAttribute("loginError", "Invalid username or password.");
            return "student/login";
        }
    }
    @GetMapping("/dashboard")
    public String studentDashboard(Model model) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            Long userId = (Long) session.getAttribute("userId");
            if (userId != null) {
                Users user = userService.findById(userId);
                Pattern pattern = Pattern.compile("^[^@]+");
                Matcher matcher = pattern.matcher(user.getUsername());
                if (matcher.find()) {
                    model.addAttribute("username", matcher.group());
                }else {
                    model.addAttribute("username", user.getUsername());
                }
            }
        }
        model.addAttribute("content", "student/dashboard");
        return "student/layout";
    }


    @GetMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
        if (authentication != null) {
            new SecurityContextLogoutHandler().logout(request, response, authentication);
        }
        return "redirect:/";
    }
    @GetMapping("/profile")
    public String getProfile(Model model) throws Exception {
        HttpSession session = request.getSession(false);
        if (session != null) {
            Long userId = (Long) session.getAttribute("userId");
            if (userId != null) {
                Users user = userService.findById(userId);
                if (user != null) {
                    Student student = user.getStudent();
                    model.addAttribute("user", user);
                    model.addAttribute("student", student);
                    model.addAttribute("content", "student/profile");
                } else {
                    return "redirect:/login";
                }
            } else {
                return "redirect:/login";
            }
        } else {
            return "redirect:/login";
        }
        return "student/layout";
    }

    @GetMapping("/schedule")
    public String showSchedule(Model model) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            Long userId = (Long) session.getAttribute("userId");
            if (userId != null) {

            }
        }

        model.addAttribute("content", "student/schedule");
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

        model.addAttribute("content", "student/profile-edit");
        return "student/layout";
    }

    @PostMapping("/profile/edit")
    public String updateProfile(Model model) {
        // Redirect back to the profile page after update
        return "redirect:/student/profile";
    }

}
