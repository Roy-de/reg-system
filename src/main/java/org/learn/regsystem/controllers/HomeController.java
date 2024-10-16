package org.learn.regsystem.controllers;

import org.learn.regsystem.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    private final StudentService studentService;

    public HomeController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/home")
    public String home() {
        return "home";
    }

    public void students(){
        //studentService.create()
    }
}
