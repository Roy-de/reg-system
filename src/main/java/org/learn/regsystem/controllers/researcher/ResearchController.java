package org.learn.regsystem.controllers.researcher;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.learn.regsystem.dtos.InstitutionalResearcherDto;
import org.learn.regsystem.dtos.UsersDto;
import org.learn.regsystem.entities.InstitutionalResearcher;
import org.learn.regsystem.entities.Users;
import org.learn.regsystem.service.researcher.ResearcherService;
import org.learn.regsystem.service.researcher.ResearcherUserService;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Controller
@Slf4j
@RequestMapping("/researcher")
public class ResearchController {
    private final HttpServletRequest request;
    private final ResearcherUserService userService;
    private final ResearcherService researcherService;

    public ResearchController(HttpServletRequest request, ResearcherUserService userService, ResearcherService researcherService) {
        this.request = request;
        this.userService = userService;
        this.researcherService = researcherService;
    }

    // Login Page
    @GetMapping("/login")
    public String loginForm(Model model) {
        model.addAttribute("userDto", new UsersDto());
        return "researcher/login";
    }

    @PostMapping("/login")
    public String loginTo(Model model, @ModelAttribute("userDto")UsersDto usersDto) throws Exception {
        Users users = userService.login(usersDto);
        if (users != null) {
            HttpSession session = request.getSession();
            session.setAttribute("userId", users.getUserId());
            return "redirect:/researcher/dashboard";
        }else {
            model.addAttribute("loginError", "Invalid username or password.");
            return "researcher/login";
        }
    }

    // Researcher Dashboard
    @GetMapping("/dashboard")
    public String researcherDashboard(Model model) {
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
        model.addAttribute("content", "researcher/dashboard");
        return "researcher/layout";
    }

    // Logout
    @GetMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
        if (authentication != null) {
            new SecurityContextLogoutHandler().logout(request, response, authentication);
        }
        return "redirect:/";
    }

    // View Profile
    @GetMapping("/profile")
    public String getProfile(Model model) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            Long userId = (Long) session.getAttribute("userId");
            Users user = userService.findById(userId);
            if (userId != null) {
                InstitutionalResearcher researcher = researcherService.findByUserId(userId);
                model.addAttribute("email",user.getUsername());
                model.addAttribute("researcher", Objects.requireNonNullElseGet(researcher, InstitutionalResearcherDto::new));
            }
        }
        model.addAttribute("content", "researcher/profile");
        return "researcher/layout";
    }

    // Edit Profile
    @GetMapping("/profile/edit")
    public String editProfileForm(Model model) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            Long userId = (Long) session.getAttribute("userId");
            InstitutionalResearcher researcher = researcherService.findByUserId(userId);
            if (researcher != null && researcher.getDateOfBirth() != null) {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                String formattedDateOfBirth = researcher.getDateOfBirth().format(formatter);
                model.addAttribute("dateOfBirthFormatted", formattedDateOfBirth);
            }
            model.addAttribute("researcher", researcher);
        }

        model.addAttribute("content", "researcher/profile-edit");
        return "researcher/layout";
    }

    @PostMapping("/profile/save")
    public String updateProfile(Model model,@ModelAttribute("researcher") InstitutionalResearcherDto researcher) throws Exception {
        researcherService.update(researcher);
        HttpSession session = request.getSession(false);
        if (session != null) {
            Long userId = (Long) session.getAttribute("userId");
            Users user = userService.findById(userId);
            if (userId != null) {
                model.addAttribute("email",user.getUsername());
                model.addAttribute("researcher", Objects.requireNonNullElseGet(researcher, InstitutionalResearcherDto::new));
            }
        }
        model.addAttribute("content", "researcher/profile");
        return "redirect:/researcher/layout";
    }

    // Change Password
    @GetMapping("/change-password")
    public String showChangePassword(Model model) {
        model.addAttribute("content", "researcher/change-password");
        return "researcher/layout";
    }

    @PostMapping("/change-password")
    public String updatePassword(@RequestParam String newPassword, Model model) {
        if (true) {
            return "redirect:/researcher/profile";
        } else {
            model.addAttribute("errorMessage", "Password change failed. Try again.");
            return "researcher/layout";
        }
    }

    // View Master Schedule
    @GetMapping("/master-schedule")
    public String viewMasterSchedule(Model model) {
        model.addAttribute("content", "researcher/master-schedule");
        return "researcher/layout";
    }

    // Search Schedule by various filters
    @GetMapping("/search-schedule")
    public String showSearchSchedule(Model model) {
        model.addAttribute("content", "researcher/search-schedule");
        return "researcher/layout";
    }

    @PostMapping("/search-schedule")
    public String searchSchedule(@RequestParam Map<String, String> filters, Model model) {
        model.addAttribute("content", "researcher/search-schedule-results");
        return "researcher/layout";
    }

    // View Available Programs
    @GetMapping("/programs")
    public String showPrograms(Model model) {
        model.addAttribute("content", "researcher/programs");
        return "researcher/layout";
    }

    // View Major/Minor Requirements
    @GetMapping("/programs/requirements")
    public String viewProgramRequirements(@PathVariable String programId, Model model) {
        model.addAttribute("content", "researcher/program-requirements");
        return "researcher/layout";
    }

    // View Course Prerequisites
    @GetMapping("/courses/prerequisites")
    public String viewCoursePrerequisites(@PathVariable String courseId, Model model) {
        model.addAttribute("content", "researcher/course-prerequisites");
        return "researcher/layout";
    }

    // Search Departments by School
    @GetMapping("/departments")
    public String searchDepartments(Model model) {
        model.addAttribute("content", "researcher/departments");
        return "researcher/layout";
    }

    @PostMapping("/departments")
    public String searchDepartmentsBySchool(@RequestParam String school, Model model) {
        model.addAttribute("content", "researcher/departments");
        return "researcher/layout";
    }
}
