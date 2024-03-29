package com.project.repository;

import com.project.model.Post;
import com.project.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findPostsByUser(User user);

    Post findPostById(Long postId);
}
