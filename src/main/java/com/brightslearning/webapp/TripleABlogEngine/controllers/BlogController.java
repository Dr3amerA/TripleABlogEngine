package com.brightslearning.webapp.TripleABlogEngine.controllers;

import com.brightslearning.webapp.TripleABlogEngine.entity.Post;
import com.brightslearning.webapp.TripleABlogEngine.service.FillDatabase;
import com.brightslearning.webapp.TripleABlogEngine.service.PostHTMLService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


import java.util.List;


@Controller
public class BlogController {

    private PostHTMLService postHTMLService;
    private FillDatabase fillDatabase;

    @Autowired
    public BlogController(PostHTMLService postHTMLService,
                          FillDatabase fillDatabase) {
        this.postHTMLService = postHTMLService;
        this.fillDatabase = fillDatabase;
    }


    @GetMapping("/") //http://localhost:8080/?name=Bob
    public String index(Model model, @RequestParam String name) {
        model.addAttribute("name", name);
        return "index";
    }

    @GetMapping("/filldb") //http://localhost:8080/filldb?code=AAA
    public String build(@RequestParam String code) {
        if (code.equals("AAA")) {
           fillDatabase.createTestData();
        }
        return "blogspot";
    }

    @GetMapping("/blogspot")
    public String showPosts(Model model) {

        List<Post> posts = postHTMLService.getPostsInHTML();

        model.addAttribute("posts", posts);

        return "blogspot";
    }
}
