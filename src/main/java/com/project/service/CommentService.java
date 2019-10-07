package com.project.service;

import com.project.model.Comment;
import org.springframework.http.HttpStatus;

public interface CommentService {
    public Comment createComment(Comment newComment);

    public HttpStatus deleteComment(Long commentId);
}
