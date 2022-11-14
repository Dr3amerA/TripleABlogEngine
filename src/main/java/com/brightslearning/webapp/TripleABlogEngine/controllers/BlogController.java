package com.brightslearning.webapp.TripleABlogEngine.controllers;

import com.brightslearning.webapp.TripleABlogEngine.service.PostHTMLService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BlogController {

    private PostHTMLService postHTMLService;

    @Autowired
    public BlogController(PostHTMLService postHTMLService) {
        this.postHTMLService = postHTMLService;
    }

    @GetMapping("/blogspot")
    @ResponseBody
    public String showPosts() {
        String response = postHTMLService.getPostsInHTML();
        return response;
    }
}
