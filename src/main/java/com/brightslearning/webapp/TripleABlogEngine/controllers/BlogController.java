package com.brightslearning.webapp.TripleABlogEngine.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BlogController {

    @GetMapping("/")
    @ResponseBody
    public String addStudent() {

        return "test";
    }
}