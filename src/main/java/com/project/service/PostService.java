package com.project.service;

import com.project.model.Post;
import org.springframework.http.HttpStatus;

import java.util.List;

public interface PostService {
   public Post createPost(Post newPost);

   public List<Post> listPostsOfUser(String username);

   public List<Post> listAllPosts();

   public HttpStatus deleteById(Long postId) throws Exception;

   List<Post> listPosts();
}
