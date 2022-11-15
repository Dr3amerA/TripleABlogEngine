package com.brightslearning.webapp.TripleABlogEngine.repository;

import com.brightslearning.webapp.TripleABlogEngine.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CommentRepository extends JpaRepository<Comment, Integer> {
}
