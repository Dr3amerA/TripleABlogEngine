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
import java.util.HashSet;
import java.util.Set;

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
        user1.setUsername("Adam");
        user1.setUserType(UserTypes.ADMINISTRATOR);
        user1.setPassword("123456");

        User user2 = new User();
        user2.setUsername("Alexandros");
        user2.setUserType(UserTypes.ADMINISTRATOR);
        user2.setPassword("qwerty");

        User user3 = new User();
        user3.setUsername("Attila");
        user3.setUserType(UserTypes.ADMINISTRATOR);
        user3.setPassword("vbTZ54");

        User user4 = new User();
        user4.setUsername("Erik");
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
        post1.setCreatorId(1);
        post1.setVisible(true);

        Post post2 = new Post();
        post2.setTitle("2nd Post");
        post2.setBody("It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. ");
        post2.setCreatorId(1);
        post2.setVisible(true);

        Post post3 = new Post();
        post3.setTitle("3rd Post");
        post3.setBody("\"Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo. ");
        post3.setCreatorId(2);
        post3.setVisible(true);

        Post post4 = new Post();
        post4.setTitle("4th Post");
        post4.setBody("But I must explain to you how all this mistaken idea of denouncing pleasure and praising pain was born and I will give you a complete account of the system, ...");
        post4.setCreatorId(3);
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
        comment1.setPostID(1);
        comment1.setUserID(3);


        Comment comment2 = new Comment();
        comment2.setComment("Thank you, Attila");
        comment2.setVisible(true);
        comment2.setPostID(1);
        comment2.setUserID(1);

        Comment comment3 = new Comment();
        comment3.setComment("Congrats on it!");
        comment3.setVisible(true);
        comment3.setPostID(1);
        comment3.setUserID(2);

        Comment comment4 = new Comment();
        comment4.setComment("I think it could have been explained better");
        comment4.setVisible(true);
        comment4.setPostID(3);
        comment4.setUserID(4);

        Comment comment5 = new Comment();
        comment5.setComment("I will work on it more, and edit it");
        comment5.setVisible(true);
        comment5.setPostID(3);
        comment5.setUserID(3);

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

        // building the relationships between posts and comments
        // Why do we have to do this? o)
        Set<Comment> post1Comments = new HashSet<>();
        post1Comments.add(comment1);
        post1Comments.add(comment2);
        post1Comments.add(comment3);
        post1.setComments(post1Comments);
        postRepository.save(post1);

        Set<Comment> post3Comments = new HashSet<>();
        post3Comments.add(comment4);
        post3Comments.add(comment5);
        post3.setComments(post3Comments);
        postRepository.save(post3);

        // building the relationships between users and posts
        // Why do we have to do this? o)

        Set<Post> user1Posts = new HashSet<>();
        user1Posts.add(post1);
        user1Posts.add(post2);
        user1.setPosts(user1Posts);
        userRepository.save(user1);

        Set<Post> user2Posts = new HashSet<>();
        user2Posts.add(post3);
        user2.setPosts(user2Posts);
        userRepository.save(user2);

        Set<Post> user3Posts = new HashSet<>();
        user3Posts.add(post4);
        user3.setPosts(user3Posts);
        userRepository.save(user3);

        // building the relationships between users and comments
        // Why do we have to do this? o)

        Set<Comment> user1Comments = new HashSet<>();
        user1Comments.add(comment2);
        user1.setComments(user1Comments);
        userRepository.save(user1);

        Set<Comment> user2Comments = new HashSet<>();
        user2Comments.add(comment3);
        user2.setComments(user2Comments);
        userRepository.save(user2);

        Set<Comment> user3Comments = new HashSet<>();
        user3Comments.add(comment1);
        user3Comments.add(comment5);
        user3.setComments(user3Comments);
        userRepository.save(user3);

        Set<Comment> user4Comments = new HashSet<>();
        user4Comments.add(comment4);
        user4.setComments(user4Comments);
        userRepository.save(user4);

    }
}
