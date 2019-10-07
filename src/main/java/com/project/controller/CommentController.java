package com.project.controller;

import com.project.model.Comment;
import com.project.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class CommentController {
    @Autowired
    CommentService commentService;

    @PostMapping("/comment")
    public Comment createComment(@RequestBody Comment newComment){
        return commentService.createComment(newComment);
    }

    @DeleteMapping("/comment/delete/{commentId}")
    public HttpStatus deleteComment(@PathVariable Long commentId){
        return commentService.deleteComment(commentId);
    }
}
