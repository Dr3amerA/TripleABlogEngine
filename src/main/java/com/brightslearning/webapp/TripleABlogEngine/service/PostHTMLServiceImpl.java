package com.brightslearning.webapp.TripleABlogEngine.service;

import com.brightslearning.webapp.TripleABlogEngine.entity.Post;
import com.brightslearning.webapp.TripleABlogEngine.repository.PostRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class PostHTMLServiceImpl implements PostHTMLService{

    private PostRepository postRepository;

    public PostHTMLServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public String getPostsInHTML() {
        Optional<Post> post1 = postRepository.findById(1);
        post1.get().setCreateDateTime(LocalDateTime.now().minusDays(1));
        postRepository.save(post1.get());
        Optional<Post> post2 = postRepository.findById(2);
        post2.get().setCreateDateTime(LocalDateTime.now());
        postRepository.save(post2.get());

        String blogspot = "<html><body>";
        Iterable<Post> posts = postRepository.findAll();
//        postRepository.findPostOrderByCreateDateTimeDesc();
        for (Post post : posts) {
            blogspot += String.format("<h3>%s</h3><br>%s<br>Created: %s<hr>", post.getTitle(), post.getBody(), post.getCreateDateTime());
        }

        blogspot += "</body></html>";
        return blogspot;
    }
}
