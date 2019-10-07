package com.project.service;

import com.project.model.Comment;
import com.project.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    CommentRepository commentRepository;


    @Override
    public Comment createComment(Comment newComment) {
        return commentRepository.save(newComment);
    }
}
