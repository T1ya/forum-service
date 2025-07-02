package ait.cohort5860.post.service;

import ait.cohort5860.post.dto.AddCommentDto;
import ait.cohort5860.post.dto.NewPostDto;
import ait.cohort5860.post.dto.PostDto;

import java.time.LocalDate;
import java.util.Set;

public interface PostService {

    PostDto addPost(String author, NewPostDto newPostDto);

    PostDto findPostById(Long postId);

    void addLike(Long postId);

    PostDto updatePost(long id, NewPostDto newPostDto);

    PostDto addComment(long postId, String author, AddCommentDto addCommentDto);

    PostDto deletePost(long postId);

    Iterable<PostDto> findPostsByTag(Set<String> tags);

    Iterable<PostDto> findPostsByPeriod(LocalDate start, LocalDate end);

    Iterable<PostDto> findPostsByAuthor(String author);
}

