package org.learn.regsystem.controllers.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("admin")
public class AdminController {

    //1. Authentication and Authorization
    @GetMapping("/login")
    public String login(Model model) {
        return "admin/login"; // Returns the login page
    }

    //2. Admin Console (Main Dashboard)
    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        model.addAttribute("content", "admin/dashboard");
        return "admin/layout"; // Returns the main dashboard
    }

    //3. View Profile
    @GetMapping("profile")
    public String profile(Model model) {
        model.addAttribute("content", "admin/profile");
        return "admin/layout";
    }

    //4. Update Profile
    @PostMapping("profile-edit")
    public String profileEdit(Model model) {
        model.addAttribute("content", "admin/profile-edit");
        return "admin/layout";
    }

    //5. Password
    @PostMapping("/change-password")
    public String changePasswordAdmin(Model model){
        model.addAttribute("content", "admin/change-password");
        return "admin/layout";
    }

    // Courses
    //6. Get Catalog
    @GetMapping("/courses")
    public String catalog(Model model) {
        model.addAttribute("content", "admin/courses/view");
        return "admin/layout";
    }

    //7. Create
    @PostMapping("/courses/create")
    public String catalogCreate(Model model){
        model.addAttribute("content", "admin/courses/create");
        return "admin/layout";
    }

    //8. Update
    @PostMapping("/courses/update")
    public String catalogUpdate(Model model){
        model.addAttribute("content", "admin/courses/update-catalog");
        return "admin/layout";
    }

    //9. Delete
    @DeleteMapping("/courses/{id}")
    public String catalogDelete(Model model, @PathVariable("id") String id){
        model.addAttribute("content", "admin/courses/view");
        return "admin/layout";
    }

    //10. Search
    @GetMapping("/courses/search/{courseName}/{department}")
    public String catalogSearch(Model model, @PathVariable("courseName") String courseName, @PathVariable("department") String department){
        model.addAttribute("content", "admin/courses/search");
        return "admin/layout";
    }

    // User Management
    @GetMapping("/users/create")
    public String createUser(Model model) {
        model.addAttribute("content", "admin/users/create");
        return "admin/layout"; // Returns create user form
    }

    @GetMapping("/users/manage")
    public String manageUsers(Model model) {
        model.addAttribute("content", "admin/users/manage");
        return "admin/layout"; // Returns manage users page
    }

    @GetMapping("/users/profile")
    public String userProfile(Model model) {
        model.addAttribute("content", "admin/users/profile");
        return "admin/layout"; // Returns user profile page
    }

    @GetMapping("/users/change-password")
    public String changePassword(Model model) {
        model.addAttribute("content", "admin/users/change-password");
        return "admin/users/change-password"; // Returns change password page
    }

    // Course Management
    @GetMapping("/courses/assign")
    public String courseAssignment(Model model) {
        model.addAttribute("content", "admin/courses/assign");
        return "admin/layout"; // Returns course assignment page
    }

    @GetMapping("/courses/registration")
    public String courseRegistration(Model model) {
        model.addAttribute("content", "admin/courses/registration");
        return "admin/layout"; // Returns course registration page
    }

    @GetMapping("/courses/attendance")
    public String attendanceManagement(Model model) {
        model.addAttribute("content", "admin/courses/attendance");
        return "admin/layout"; // Returns attendance management page
    }

    @GetMapping("/courses/grades")
    public String gradeAssignment(Model model) {
        model.addAttribute("content", "admin/courses/grades");
        return "admin/layout"; // Returns grade assignment page
    }

    // Advisement Management
    @GetMapping("/advisement/overview")
    public String advisementOverview(Model model) {
        model.addAttribute("content", "admin/advisement/overview");
        return "admin/layout"; // Returns advisement overview page
    }

    @GetMapping("/advisement/assign")
    public String assignAdvisor(Model model) {
        model.addAttribute("content", "admin/advisement/assign");
        return "admin/layout"; // Returns assign advisor page
    }

    @GetMapping("/advisement/advisor-profile")
    public String advisorProfile(Model model) {
        model.addAttribute("content", "admin/advisement/advisor-profile");
        return "admin/advisement/advisor-profile"; // Returns advisor profile page
    }

    // Student Record Management
    @GetMapping("/students/profile")
    public String studentProfile(Model model) {
        model.addAttribute("content", "admin/students/profile");
        return "admin/layout"; // Returns student profile page
    }

    @GetMapping("/students/academic-program")
    public String academicProgram(Model model) {
        model.addAttribute("content", "admin/students/academic-program");
        return "admin/layout"; // Returns academic program management page
    }

    @GetMapping("/students/semester-schedule")
    public String semesterSchedule(Model model) {
        model.addAttribute("content", "admin/students/semester-schedule");
        return "admin/layout"; // Returns semester schedule page
    }

    @GetMapping("/students/transcript")
    public String unofficialTranscript(Model model) {
        model.addAttribute("content", "admin/students/transcript");
        return "admin/layout"; // Returns unofficial transcript page
    }

    // Faculty Record Management
    @GetMapping("/faculty/profile")
    public String facultyProfile(Model model) {
        model.addAttribute("content", "admin/faculty/profile");
        return "admin/layout"; // Returns faculty profile page
    }

    @GetMapping("/faculty/schedule")
    public String facultySchedule(Model model) {
        model.addAttribute("content", "admin/faculty/schedule");
        return "admin/layout"; // Returns faculty schedule page
    }

    // Researcher Account Management
    @GetMapping("/researcher/profile")
    public String researcherProfile(Model model) {
        model.addAttribute("content", "admin/researcher/profile");
        return "admin/layout"; // Returns researcher profile page
    }

    @GetMapping("/researcher/change-password")
    public String changeResearcherPassword(Model model) {
        model.addAttribute("content", "admin/researcher/change-password");
        return "admin/layout"; // Returns change password page for researchers
    }

    // Administrative Constraints Management
    @GetMapping("/constraints/manage")
    public String manageConstraints(Model model) {
        model.addAttribute("content", "admin/constraints/manage");
        return "admin/layout"; // Returns constraint management page
    }

    // Error Notifications
    @GetMapping("/notifications")
    public String errorNotifications(Model model) {
        model.addAttribute("content", "admin/notifications");
        return "admin/layout"; // Returns notifications page for errors
    }

    /**
     * 1. Create Master schedule
     * 2. Update master schedule
     */
    @PostMapping("/master-schedule-create")
    public String masterScheduleCreate(Model model) {
        model.addAttribute("content", "admin/schedule/create-master-schedule");
        return "admin/layout";
    }
    @PutMapping("master-schedule-update")
    public String masterScheduleUpdate(Model model) {
        model.addAttribute("content", "admin/schedule/update-master-schedule");
        return "admin/layout";
    }
}


