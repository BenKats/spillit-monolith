package com.project.controller;

import com.project.config.JwtResponse;
import com.project.model.Post;
import com.project.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PostController {

    @Autowired
    PostService postService;

    @PostMapping("/post")
    public Post createPost (@RequestBody Post newPost){
        return postService.createPost(newPost);
    }

    @GetMapping("/list-posts-of/{username}")
    public List<Post> listPostsOfUser(@PathVariable String username){
        return postService.listPostsOfUser(username);
    }

    @GetMapping("/list-all-posts")
    public List<Post> listAllPosts(){
        return postService.listAllPosts();
    }


    @DeleteMapping("/post/delete/{postId}")
    public HttpStatus deletePostById (@PathVariable Long postId){
        return postService.deleteById(postId);
    }


}