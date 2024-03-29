package com.project.controller;

import com.project.model.Post;
import com.project.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/post")
public class PostController {

    @Autowired
    PostService postService;

    @PostMapping
    public Post createPost (@RequestBody Post newPost){
        return postService.createPost(newPost);
    }

    @GetMapping("/list-posts-of/{username}")
    public List<Post> listPostsOfUser(@PathVariable String username){
        return postService.listPostsOfUser(username);
    }

    @GetMapping("/list")
    public List<Post> listPosts(){
        return postService.listPosts();
    }

    @GetMapping("/list-all")
    public List<Post> listAllPosts(){
        return postService.listAllPosts();
    }


    @DeleteMapping("/delete/{postId}")
    public HttpStatus deletePostById (@PathVariable Long postId){
        try{
            return postService.deleteById(postId);
        }
        catch (Exception exc){
            throw new ResponseStatusException(
                    HttpStatus.UNAUTHORIZED, "Attempt To Delete Other User's Post", exc);
        }

    }

}