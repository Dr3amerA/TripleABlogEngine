package com.brightslearning.webapp.TripleABlogEngine.repository;

import com.brightslearning.webapp.TripleABlogEngine.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Integer> {
//    List<Post> findPostOrderByCreateDateTimeDesc();
//    List<Post> findPostOrderByCreateDateTime();
}
