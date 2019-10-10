package com.project.service;

import com.project.model.Comment;
import org.springframework.http.HttpStatus;

import java.util.List;

public interface CommentService {
    public Comment createCommentForUser(Comment newComment, Long postId, String username);

    public Comment createComment(Comment newComment, Long postId);

    public List<Comment> listCommentsOfUser(String username);

    public List<Comment>listCommentsOfPost(Long postId);

    public List<Comment> listAllComments();

    public HttpStatus deleteComment(Long commentId);


}
