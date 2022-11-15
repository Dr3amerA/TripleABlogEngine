package com.brightslearning.webapp.TripleABlogEngine.controllers;

import com.brightslearning.webapp.TripleABlogEngine.entity.Post;
import com.brightslearning.webapp.TripleABlogEngine.service.CommentHTMLService;
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
    private CommentHTMLService commentHTMLService;
    private FillDatabase fillDatabase;

    @Autowired
    public BlogController(PostHTMLService postHTMLService, CommentHTMLService commentHTMLService, FillDatabase fillDatabase) {
        this.postHTMLService = postHTMLService;
        this.commentHTMLService = commentHTMLService;
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

//        List<User> users = new ArrayList<>();
//        User user1 = new User();
//        user1.setId(1);
//        user1.setUsername("Adam");
//        User user2 = new User();
//        user1.setId(2);
//        user1.setUsername("Alexandros");
//        User user3 = new User();
//        user1.setId(3);
//        user1.setUsername("ATtila");
//        users.add(user1);
//        users.add(user2);
//        users.add(user3);
        model.addAttribute("posts", posts);
//        model.addAttribute("users", users);

        return "blogspot";
    }

//    @GetMapping("/blogspot")
//    @ResponseBody
//    public String showPosts() {
//        String response = postHTMLService.getPostsInHTML();
//        return response;
//    }
}
