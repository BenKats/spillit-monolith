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

import javax.transaction.Transactional;
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
    public List<Post> listPosts() {
        Authentication auth = authenticationImpl.getAuthentication();
        User user = userRepository.findByUsername(auth.getName());
        return postRepository.findPostsByUser(user);
    }

    @Override
    public List<Post> listAllPosts() {
        return postRepository.findAll();
    }

    @Override
    @Transactional
    public HttpStatus deleteById(Long postId){
        Authentication auth = authenticationImpl.getAuthentication();
        Long userId = userRepository.findByUsername(auth.getName()).getId();
        Long postUserId = postRepository.findPostById(postId).getUser().getId();
        if (userId.equals(postUserId)){
            postRepository.deleteById(postId);
            return HttpStatus.OK;
        }
        return HttpStatus.FORBIDDEN;


    }

}

