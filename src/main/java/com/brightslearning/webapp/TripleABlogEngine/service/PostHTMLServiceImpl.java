package com.brightslearning.webapp.TripleABlogEngine.service;

import com.brightslearning.webapp.TripleABlogEngine.entity.Comment;
import com.brightslearning.webapp.TripleABlogEngine.entity.Post;
import com.brightslearning.webapp.TripleABlogEngine.repository.CommentRepository;
import com.brightslearning.webapp.TripleABlogEngine.repository.PostRepository;
import com.brightslearning.webapp.TripleABlogEngine.repository.UserRepository;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class PostHTMLServiceImpl implements PostHTMLService{

    private static final String DATE_TIME_FORMAT = "yyyy/MM/dd hh:mm:ss";
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
    public List<Post> getPostsInHTML() {

        Iterable<Post> posts = postRepository.findAll(Sort.by(Direction.DESC, "createDateTime"));
        return (List<Post>) posts;
    }


}
