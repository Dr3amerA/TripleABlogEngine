package com.brightslearning.webapp.TripleABlogEngine.repository;

import com.brightslearning.webapp.TripleABlogEngine.entity.Post;
import org.springframework.data.repository.CrudRepository;

public interface PostRepository extends CrudRepository<Post, Integer> {
    void findPostOrderByCreateDateTimeDesc();
}
