package ait.cohort5860.post.dao;

import ait.cohort5860.post.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

public interface PostRepository extends JpaRepository<Post, Long> {
    Stream<Post> findAllByDateCreatedBetween(LocalDateTime dateCreatedAfter, LocalDateTime dateCreatedBefore);

    Stream<Post> findAllByAuthorIgnoreCase(String author);

    Stream<Post> findDistinctByTagsIgnoreCase_NameIn(Set<String> tags);
}
