package com.brightslearning.webapp.TripleABlogEngine.service;

import com.brightslearning.webapp.TripleABlogEngine.entity.Comment;
import com.brightslearning.webapp.TripleABlogEngine.entity.Post;
import com.brightslearning.webapp.TripleABlogEngine.entity.User;
import com.brightslearning.webapp.TripleABlogEngine.entity.UserTypes;
import com.brightslearning.webapp.TripleABlogEngine.repository.CommentRepository;
import com.brightslearning.webapp.TripleABlogEngine.repository.PostRepository;
import com.brightslearning.webapp.TripleABlogEngine.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;


@Service
public class FillDatabaseImpl implements FillDatabase{
    private UserRepository userRepository;
    private PostRepository postRepository;
    private CommentRepository commentRepository;

    public FillDatabaseImpl(UserRepository userRepository, PostRepository postRepository, CommentRepository commentRepository) {
        this.userRepository = userRepository;
        this.postRepository = postRepository;
        this.commentRepository = commentRepository;
    }

    @Override
    public void createTestData() {

        // adding users
        User user1 = new User();
        user1.setUserName("Adam");
        user1.setUserType(UserTypes.ADMINISTRATOR);
        user1.setPassword("123456");

        User user2 = new User();
        user2.setUserName("Alexandros");
        user2.setUserType(UserTypes.ADMINISTRATOR);
        user2.setPassword("qwerty");

        User user3 = new User();
        user3.setUserName("Attila");
        user3.setUserType(UserTypes.ADMINISTRATOR);
        user3.setPassword("vbTZ54");

        User user4 = new User();
        user4.setUserName("Erik");
        user4.setUserType(UserTypes.REGISTERED);
        user4.setPassword("NmJK8l");

        userRepository.save(user1);
        userRepository.save(user2);
        userRepository.save(user3);
        userRepository.save(user4);

        // adding posts
        Post post1 = new Post();
        post1.setTitle("Very 1st Post");
        post1.setBody("Lorem Ipsum is simply dummy text of the printing and typesetting industry.");
        post1.setCreator(user1);
        post1.setVisible(true);

        Post post2 = new Post();
        post2.setTitle("2nd Post");
        post2.setBody("It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. ");
        post2.setCreator(user1);
        post2.setVisible(true);

        Post post3 = new Post();
        post3.setTitle("3rd Post");
        post3.setBody("\"Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo. ");
        post3.setCreator(user2);
        post3.setVisible(true);

        Post post4 = new Post();
        post4.setTitle("4th Post");
        post4.setBody("But I must explain to you how all this mistaken idea of denouncing pleasure and praising pain was born and I will give you a complete account of the system, ...");
        post4.setCreator(user3);
        post4.setVisible(true);

        postRepository.save(post1);
        postRepository.save(post2);
        postRepository.save(post3);
        postRepository.save(post4);

        // setting post creation times to be different
        post1.setCreateDateTime(LocalDateTime.now().minusDays(3));
        post2.setCreateDateTime(LocalDateTime.now().minusDays(2));
        post3.setCreateDateTime(LocalDateTime.now().minusDays(1));
        post4.setCreateDateTime(LocalDateTime.now());
        postRepository.save(post1);
        postRepository.save(post2);
        postRepository.save(post3);
        postRepository.save(post4);

        // adding comments
        Comment comment1 = new Comment();
        comment1.setComment("It was awesome, Adam :)");
        comment1.setVisible(true);
        comment1.setPost(post1);
        comment1.setCreator(user3);


        Comment comment2 = new Comment();
        comment2.setComment("Thank you, Attila");
        comment2.setVisible(true);
        comment2.setPost(post1);
        comment2.setCreator(user1);

        Comment comment3 = new Comment();
        comment3.setComment("Congrats on it!");
        comment3.setVisible(true);
        comment3.setPost(post1);
        comment3.setCreator(user2);

        Comment comment4 = new Comment();
        comment4.setComment("I think it could have been explained better");
        comment4.setVisible(true);
        comment4.setPost(post3);
        comment4.setCreator(user4);

        Comment comment5 = new Comment();
        comment5.setComment("I will work on it more, and edit it");
        comment5.setVisible(true);
        comment5.setPost(post3);
        comment5.setCreator(user3);

        commentRepository.save(comment1);
        commentRepository.save(comment2);
        commentRepository.save(comment3);
        commentRepository.save(comment4);
        commentRepository.save(comment5);

        // changing comment creation times to be different
        comment1.setCreateDateTime(LocalDateTime.now().minusDays(2));
        comment2.setCreateDateTime(LocalDateTime.now().minusHours(20));
        comment3.setCreateDateTime(LocalDateTime.now().minusHours(19));
        comment4.setCreateDateTime(LocalDateTime.now().minusHours(10));
        comment5.setCreateDateTime(LocalDateTime.now().minusHours(6));

        commentRepository.save(comment1);
        commentRepository.save(comment2);
        commentRepository.save(comment3);
        commentRepository.save(comment4);
        commentRepository.save(comment5);

    }
}
