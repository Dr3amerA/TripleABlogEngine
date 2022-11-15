package com.brightslearning.webapp.TripleABlogEngine.service;

import com.brightslearning.webapp.TripleABlogEngine.entity.Post;
import com.brightslearning.webapp.TripleABlogEngine.repository.PostRepository;

import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PostHTMLServiceImpl implements PostHTMLService{

    private PostRepository postRepository;

    public PostHTMLServiceImpl(PostRepository postRepository                               ) {
        this.postRepository = postRepository;
    }

    @Override
    public List<Post> getPostsInHTML() {

        Iterable<Post> posts = postRepository.findAll(Sort.by(Direction.DESC, "createDateTime"));
        return (List<Post>) posts;
    }


}
