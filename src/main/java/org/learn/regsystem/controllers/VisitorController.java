package org.learn.regsystem.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class VisitorController {

    @GetMapping("/")
    public String home() {
        return "visitor";
    }
    @GetMapping("/about")
    public String about() {
        return "about";
    }
}
