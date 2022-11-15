package com.brightslearning.webapp.TripleABlogEngine.repository;

import com.brightslearning.webapp.TripleABlogEngine.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PostRepository extends JpaRepository<Post, Integer> {

}
