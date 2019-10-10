package com.project.service;

import com.project.config.AuthenticationImpl;
import com.project.model.Post;
import com.project.model.User;
import com.project.repository.PostRepository;
import com.project.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    PostRepository postRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    AuthenticationImpl authenticationImpl;

    @Override
    public Post createPost(Post newPost){
        Authentication auth = authenticationImpl.getAuthentication();
        User user = userRepository.findByUsername(auth.getName());
        newPost.setUser(user);
        return postRepository.save(newPost);
    }

    @Override
    public List<Post> listPostsOfUser(String username){
        User user = userRepository.findByUsername(username);
        return postRepository.findPostsByUser(user);
    }

    @Override
    public List<Post> listAllPosts() {
        return postRepository.findAll();
    }

    @Override
    public HttpStatus deleteById(Long postId){
        postRepository.deleteById(postId);
        return HttpStatus.OK;
    }


}

