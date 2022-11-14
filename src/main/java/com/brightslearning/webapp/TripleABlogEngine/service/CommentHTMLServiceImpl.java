package com.brightslearning.webapp.TripleABlogEngine.service;

import com.brightslearning.webapp.TripleABlogEngine.entity.Comment;
import com.brightslearning.webapp.TripleABlogEngine.repository.CommentRepository;
import com.brightslearning.webapp.TripleABlogEngine.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class CommentHTMLServiceImpl implements CommentHTMLService{
    private static String DATE_TIME_FORMAT = "yyyy/MM/dd hh:mm:ss";
    private CommentRepository commentRepository;
    private UserRepository userRepository;

    public CommentHTMLServiceImpl(CommentRepository commentRepository, UserRepository userRepository) {
        this.commentRepository = commentRepository;
        this.userRepository = userRepository;
    }

    @Override
    public String getCommentsForPost(Integer postId) {
        String commentsForBlog = "<br>comments<br>";

        List<Comment> comments = commentRepository.findCommentByPostIDOrderByCreateDateTime(postId);
//        List<Comment> comments = commentRepository.findCommentByPostIDOrderByCreateDateTime(postId);
        for (Comment comment : comments) {
            commentsForBlog += String.format("<br>%s<br>Created by %s at: %s<br>",
                    comment.getComment(),
                    userRepository.findById(comment.getUserID()).get().getUsername(),
                    comment.getCreateDateTime().format(DateTimeFormatter.ofPattern(DATE_TIME_FORMAT)));
        }
        return commentsForBlog;
    }
}
