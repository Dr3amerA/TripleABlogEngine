package com.brightslearning.webapp.TripleABlogEngine.repository;

import com.brightslearning.webapp.TripleABlogEngine.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
}
