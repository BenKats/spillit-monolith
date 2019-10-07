package com.project.service;

import com.project.model.Post;
import org.springframework.http.HttpStatus;

import java.util.List;

public interface PostService {

    Post createPost(Post newPost);

    List<Post> listPosts();

    HttpStatus deleteById(Long postId);
}
