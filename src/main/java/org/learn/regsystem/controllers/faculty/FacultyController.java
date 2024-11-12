package org.learn.regsystem.controllers.faculty;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.learn.regsystem.dtos.UsersDto;
import org.learn.regsystem.entities.*;
import org.learn.regsystem.service.faculty.AdvisementService;
import org.learn.regsystem.service.faculty.FacultyUserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/faculty")
public class FacultyController {
    private final AdvisementService advisementService;
    private final FacultyUserService userService;
    private final HttpServletRequest request;

    public FacultyController(AdvisementService advisementService, FacultyUserService userService, HttpServletRequest request) {
        this.advisementService = advisementService;
        this.userService = userService;
        this.request = request;
    }

    // =============================== Faculty Home & Console ===============================

    @GetMapping("/login")
    public String viewFacultyHomePage(Model model) {
        model.addAttribute("userDto", new UsersDto());
        return "faculty/login";
    }
    @PostMapping("/login")
    public String loginTo(Model model,@ModelAttribute("userDto")UsersDto usersDto) throws Exception {
        Users users = userService.login(usersDto);
        if (users != null) {
            HttpSession session = request.getSession();
            session.setAttribute("userId", users.getUserId());
            return "redirect:/faculty/dashboard";
        }else {
            model.addAttribute("loginError", "Invalid username or password.");
            return "student/login";
        }
    }

    @GetMapping("/dashboard")
    public String viewFacultyConsole(Model model) throws Exception {
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
        model.addAttribute("content", "faculty/dashboard");
        return "faculty/layout";
    }

    // =============================== Advisement Pages ===============================

    @GetMapping("/advisement")
    public String viewAdvisementConsole(Model model) throws Exception {
        HttpSession session = request.getSession(false);
        if (session != null) {
            Long userId = (Long) session.getAttribute("userId");
            if (userId != null) {
                Users user = userService.findById(userId);
                Faculty faculty = user.getFaculty();
                if(faculty != null) {
                    List<String> departmentNames = faculty.getDepartments()
                            .stream()
                            .map(Department::getName)
                            .collect(Collectors.toList());
                    Advisor advisor = faculty.getAdvisor();
                    model.addAttribute("faculty", faculty);
                    Student advisee = advisor.getStudent();
                    model.addAttribute("departmentNames", departmentNames);
                    model.addAttribute("advisor", advisor);
                    model.addAttribute("advisees", advisee);

                }
            }
        }
        model.addAttribute("content", "faculty/advisements");
        return "faculty/layout";
    }

    @GetMapping("/advisees/personal")
    public String viewPersonalAdvisees(Model model) {
        model.addAttribute("advisees", "");
        return "faculty/layout";
    }

    @GetMapping("/advisees/all")
    public String viewAllAdvisees(Model model) {
        model.addAttribute("advisees","");
        return "faculty/layout";
    }

    @GetMapping("/advisees/degreeAudit")
    public String viewStudentDegreeAudit(Model model) {
        model.addAttribute("degreeAudit", "");
        return "faculty/layout";
    }

    @GetMapping("/advisees/personalInfo")
    public String viewStudentPersonalInfo(Model model) {
        model.addAttribute("student", "");
        return "faculty/layout";
    }

    @GetMapping("/advisees/holds")
    public String viewStudentHolds(Model model) {
        model.addAttribute("holds", "");
        return "faculty/layout";
    }

    @GetMapping("/advisees/semesterSchedule")
    public String viewStudentSemesterSchedule(Model model) {
        model.addAttribute("schedule", "");
        return "faculty/layout";
    }

    @GetMapping("/advisees/transcript")
    public String viewUnofficialTranscript(Model model) {
        model.addAttribute("transcript", "");
        return "faculty/layout";
    }

    // =============================== Faculty Schedule & Course Section Pages ===============================

    @GetMapping("/semesterSchedule")
    public String viewFacultySemesterSchedule(Model model) {
        model.addAttribute("courses", "");
        return "faculty/layout";
    }

    @GetMapping("/course/{courseId}/roster")
    public String viewCourseRoster(@PathVariable("courseId") Long courseId, Model model) {
        model.addAttribute("roster", "");
        return "faculty/layout";
    }

    @PostMapping("/course/{courseId}/assignGrades")
    public String assignGrades(@PathVariable("courseId") Long courseId, @RequestParam Map<String, String> grades) {

        return "redirect:/faculty/course/" + courseId + "/roster";
    }

    @PostMapping("/course/{courseId}/assignAttendance")
    public String assignAttendance(@PathVariable("courseId") Long courseId, @RequestParam Map<String, String> attendance) {

        return "redirect:/faculty/course/" + courseId + "/roster";
    }

    // =============================== Account Management Pages ===============================

    @GetMapping("/profile")
    public String viewProfile(Model model) {
        model.addAttribute("faculty", "");
        return "accountPage";
    }

    @PostMapping("/profile/updatePassword")
    public String updatePassword(@RequestParam String newPassword, @RequestParam String confirmPassword, Model model) {

        if (false) {
            model.addAttribute("error", "Password update failed. Please check requirements.");
        }
        return "redirect:/faculty/profile";
    }

    @PostMapping("/profile/updateInfo")
    public String updatePersonalInfo(@ModelAttribute Faculty faculty) {
        return "redirect:/faculty/profile";
    }

    // =============================== Course Catalog Pages ===============================

    @GetMapping("/masterSchedule")
    public String viewMasterSchedule(Model model) {
        model.addAttribute("masterSchedule", "");
        return "masterSchedule";
    }

    @GetMapping("/catalog/majorsMinors")
    public String viewMajorsMinors(Model model) {
        model.addAttribute("programs", "");
        return "majorsMinors";
    }

    @GetMapping("/catalog/courses")
    public String viewCourseCatalog(Model model) {
        model.addAttribute("courses", "");
        return "courses";
    }

    @GetMapping("/catalog/course/{courseId}/prerequisites")
    public String viewCoursePrerequisites(@PathVariable("courseId") Long courseId, Model model) {
        model.addAttribute("prerequisites", "courseService.getCoursePrerequisites(courseId)");
        return "coursePrerequisites";
    }
}
