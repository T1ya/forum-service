package ait.cohort5860.post.dao;

import ait.cohort5860.post.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findAllByDateCreatedBetween(LocalDateTime dateCreatedAfter, LocalDateTime dateCreatedBefore);

    List<Post> findAllByAuthor(String author);
}
