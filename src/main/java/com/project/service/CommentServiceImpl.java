package com.project.service;

import com.project.model.Comment;
import com.project.model.Post;
import com.project.model.User;
import com.project.repository.CommentRepository;
import com.project.repository.PostRepository;
import com.project.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    CommentRepository commentRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    PostRepository postRepository;


    @Override
    public Comment createComment(Comment newComment, Long postId, String username) {
        User user = userRepository.findByUsername(username);
        Post post = postRepository.findPostById(postId);
        newComment.setUser(user);
        newComment.setPost(post);
        return commentRepository.save(newComment);
    }

    @Override
    public List<Comment> listCommentsOfUser(String username) {
        User user = userRepository.findByUsername(username);
        return commentRepository.findCommentsByUser(user);
    }

    @Override
    public List<Comment> listCommentsOfPost(Long postId) {
        Post post = postRepository.findPostById(postId);
        return commentRepository.findCommentsByPost(post);
    }

    @Override
    public List<Comment> listAllComments() {
        return commentRepository.findAll();
    }

    @Override
    public HttpStatus deleteComment(Long commentId) {
        commentRepository.deleteById(commentId);
        return HttpStatus.valueOf(200);
    }
}
