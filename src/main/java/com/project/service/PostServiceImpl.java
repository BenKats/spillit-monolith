package com.project.service;

import com.project.model.Post;
import com.project.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    PostRepository postRepository;

    @Override
    public Post createPost(Post newPost){
        return postRepository.save(newPost);
    }

    @Override
    public List<Post> listPosts(){
        return postRepository.findAll();
    }

    @Override
    public HttpStatus deleteById(Long postId){
        postRepository.deleteById(postId);
        return HttpStatus.OK;
    }

}

