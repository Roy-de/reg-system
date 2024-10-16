package org.learn.regsystem.controllers.Course;

import org.learn.regsystem.dtos.CourseDto;
import org.learn.regsystem.entities.Course;
import org.learn.regsystem.service.CourseService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class CourseController {
    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping("/academics/catalog")
    public String getCourseCatalog(Model model) throws Exception {

        try{
            List<Course> courses = courseService.findAll();
            model.addAttribute("courses", courses);
            return "academics/catalog";

        } catch (Exception e) {
                throw new RuntimeException(e);
        }
    }
    @GetMapping("/catalog")
    public String searchCourseCatalog(@RequestParam(required = false) String courseName,
                                      Model model) throws Exception {
        List<Course> courses;
        if ((courseName == null || courseName.isEmpty())) {
            courses = courseService.findAll();
        } else {
            courses = courseService.searchByParameters(courseName);
        }
        model.addAttribute("courses", courses);
        return "catalog";
    }

    @GetMapping("/schedule")
    public String getCourseSchedule(Model model) throws Exception {
        return "academics/schedule";
    }
}
