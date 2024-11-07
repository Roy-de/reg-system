package org.learn.regsystem.controllers.researcher;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@Slf4j
@RequestMapping("/researcher")
public class ResearchController {


    // Login Page
    @GetMapping("/login")
    public String loginForm(Model model) {

        return "researcher/login";
    }

    @PostMapping("/login")
    public String loginTo(Model model) throws Exception {
        if (true) {
            return "redirect:/researcher/dashboard";
        } else {
            model.addAttribute("loginError", "Invalid username or password.");
            return "researcher/login";
        }
    }

    // Researcher Dashboard
    @GetMapping("/dashboard")
    public String researcherDashboard(Model model) {
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
        model.addAttribute("content", "researcher/profile");
        return "researcher/layout";
    }

    // Edit Profile
    @GetMapping("/profile/edit")
    public String editProfileForm(Model model) {
        model.addAttribute("content", "researcher/profile-edit");
        return "researcher/layout";
    }

    @PostMapping("/profile/edit")
    public String updateProfile(Model model) {
        return "redirect:/researcher/profile";
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
