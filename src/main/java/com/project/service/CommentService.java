package com.project.service;

import com.project.model.Comment;
import org.springframework.http.HttpStatus;

public interface CommentService {
    public Comment createComment(Comment newComment, Long postId, String username);

    public HttpStatus deleteComment(Long commentId);
}
