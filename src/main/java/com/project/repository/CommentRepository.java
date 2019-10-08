package com.project.repository;

import com.project.model.Comment;
import com.project.model.Post;
import com.project.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findCommentsByUser(User user);

    List<Comment> findCommentsByPost(Post post);

}
