package org.learn.regsystem.controllers.faculty;

import org.learn.regsystem.entities.Faculty;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@RequestMapping("/faculty")
public class FacultyController {

    // =============================== Faculty Home & Console ===============================

    @GetMapping("/home")
    public String viewFacultyHomePage() {
        return "facultyHome";
    }

    @GetMapping("/console")
    public String viewFacultyConsole(Model model) {
        model.addAttribute("facultyDetails", "");
        return "facultyConsole";
    }

    // =============================== Advisement Pages ===============================

    @GetMapping("/advisement")
    public String viewAdvisementConsole(Model model) {
        model.addAttribute("advisementOptions", "");
        return "advisementConsole";
    }

    @GetMapping("/advisees/personal")
    public String viewPersonalAdvisees(Model model) {
        model.addAttribute("advisees", "");
        return "viewAdvisees";
    }

    @GetMapping("/advisees/all")
    public String viewAllAdvisees(Model model) {
        model.addAttribute("advisees","");
        return "viewAllAdvisees";
    }

    @GetMapping("/advisees/{studentId}/degreeAudit")
    public String viewStudentDegreeAudit(@PathVariable("studentId") Long studentId, Model model) {
        model.addAttribute("degreeAudit", "");
        return "degreeAudit";
    }

    @GetMapping("/advisees/{studentId}/personalInfo")
    public String viewStudentPersonalInfo(@PathVariable("studentId") Long studentId, Model model) {
        model.addAttribute("student", "");
        return "personalInfo";
    }

    @GetMapping("/advisees/{studentId}/holds")
    public String viewStudentHolds(@PathVariable("studentId") Long studentId, Model model) {
        model.addAttribute("holds", "");
        return "studentHolds";
    }

    @GetMapping("/advisees/{studentId}/semesterSchedule")
    public String viewStudentSemesterSchedule(@PathVariable("studentId") Long studentId, Model model) {
        model.addAttribute("schedule", "");
        return "studentSemesterSchedule";
    }

    @GetMapping("/advisees/{studentId}/transcript")
    public String viewUnofficialTranscript(@PathVariable("studentId") Long studentId, Model model) {
        model.addAttribute("transcript", "");
        return "unofficialTranscript";
    }

    // =============================== Faculty Schedule & Course Section Pages ===============================

    @GetMapping("/semesterSchedule")
    public String viewFacultySemesterSchedule(Model model) {
        model.addAttribute("courses", "");
        return "facultySemesterSchedule";
    }

    @GetMapping("/course/{courseId}/roster")
    public String viewCourseRoster(@PathVariable("courseId") Long courseId, Model model) {
        model.addAttribute("roster", "");
        return "courseRoster";
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
