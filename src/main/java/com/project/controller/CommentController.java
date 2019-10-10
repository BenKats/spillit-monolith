package com.project.controller;

import com.project.model.Comment;
import com.project.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CommentController {
    @Autowired
    CommentService commentService;

    @PostMapping("/comment/{postId}/{username}")
    public Comment createCommentForUser(@RequestBody Comment newComment, @PathVariable Long postId, @PathVariable String username){
        return commentService.createCommentForUser(newComment, postId, username);
    }

    @PostMapping("/comment/{postId}")
    public Comment createComment(@RequestBody Comment newComment, @PathVariable Long postId){
        return commentService.createComment(newComment, postId);
    }

    @GetMapping("/comment/list/byuser/{username}")
    public List<Comment> listCommentsOfUser(@PathVariable String username){
        return commentService.listCommentsOfUser(username);
    }

    @GetMapping("/comment/list/bypost/{postId}")
    public List<Comment> listCommentsOfPost(@PathVariable Long postId){
        return commentService.listCommentsOfPost(postId);
    }

    @GetMapping("/comment/list")
    public List<Comment> listAllComments(){
        return commentService.listAllComments();
    }

    @DeleteMapping("/comment/delete/{commentId}")
    public HttpStatus deleteComment(@PathVariable Long commentId){
        return commentService.deleteComment(commentId);
    }

}
