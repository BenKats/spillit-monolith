package com.project.service;

import com.project.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class CommentServiceImpl implements CommentService {
    @Autowired
    CommentRepository commentRepository;
}
