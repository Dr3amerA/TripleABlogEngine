package com.brightslearning.webapp.TripleABlogEngine.service;

import com.brightslearning.webapp.TripleABlogEngine.entity.Post;
import com.brightslearning.webapp.TripleABlogEngine.repository.CommentRepository;
import com.brightslearning.webapp.TripleABlogEngine.repository.PostRepository;
import com.brightslearning.webapp.TripleABlogEngine.repository.UserRepository;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@Service
public class PostHTMLServiceImpl implements PostHTMLService{

    private static String DATE_TIME_FORMAT = "yyyy/MM/dd hh:mm:ss";
    private PostRepository postRepository;
    private UserRepository userRepository;

    private CommentHTMLService commentHTMLService;

    private CommentRepository commentRepository;

    public PostHTMLServiceImpl(PostRepository postRepository, UserRepository userRepository, CommentHTMLService commentHTMLService, CommentRepository commentRepository) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
        this.commentHTMLService = commentHTMLService;
        this.commentRepository = commentRepository;
    }

    @Override
    public String getPostsInHTML() {
//        Optional<Post> post1 = postRepository.findById(1);
//        post1.get().setCreateDateTime(LocalDateTime.now().minusDays(1));
//        postRepository.save(post1.get());
//        Optional<Post> post2 = postRepository.findById(2);
//        post2.get().setCreateDateTime(LocalDateTime.now());
//        postRepository.save(post2.get());

        String blogspot = "<html><body>";
        String param = "createDateTime";
        Iterable<Post> posts = postRepository.findAll(Sort.by(Direction.DESC, param));
//        List<Post> posts = postRepository.findPostOrderByCreateDateTimeDesc();
        for (Post post : posts) {
            blogspot += String.format("<h3>%s</h3><br>%s<br>Created by %s at: %s",
                    post.getTitle(),
                    post.getBody(),
                    userRepository.findById(post.getCreatorId()).get().getUsername(),
                    post.getCreateDateTime().format(DateTimeFormatter.ofPattern(DATE_TIME_FORMAT)));
                blogspot += commentHTMLService.getCommentsForPost(post.getId());
            blogspot += "<hr>";

        }

        blogspot += "</body></html>";
        return blogspot;
    }


}
