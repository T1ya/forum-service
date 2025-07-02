package ait.cohort5860.post.controller;

import ait.cohort5860.post.dto.AddCommentDto;
import ait.cohort5860.post.dto.NewPostDto;
import ait.cohort5860.post.dto.PostDto;
import ait.cohort5860.post.service.PostService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Set;

@RestController
@RequiredArgsConstructor
@RequestMapping("/forum")
public class PostController {
    private final PostService postService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/post/{user}")
    public PostDto addPost(@PathVariable String user, @RequestBody @Valid NewPostDto newPostDto) {
        return postService.addPost(user, newPostDto);
    }

    @GetMapping("/post/{postId}")
    public PostDto findPostById(@PathVariable long postId) {
        return postService.findPostById(postId);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PatchMapping("/post/{postId}/like")
    public void addLike(@PathVariable long postId) {
        postService.addLike(postId);
    }

    @PatchMapping("/post/{postId}")
    public PostDto updatePost(@PathVariable long postId, @RequestBody @Valid NewPostDto newPostDto) {
        return postService.updatePost(postId, newPostDto);
    }

    @PatchMapping("post/{postId}/comment/{author}")
    public PostDto addComment(@PathVariable long postId, @PathVariable String author, @RequestBody @Valid AddCommentDto addCommentDto) {
        return postService.addComment(postId, author, addCommentDto);
    }

    @DeleteMapping("/post/{postId}")
    public PostDto deletePost(@PathVariable long postId) {
        return postService.deletePost(postId);
    }

    @GetMapping("/posts/tags")
    public Iterable<PostDto> findPostsByTag(@RequestParam("values") Set<String> tags) {
        return postService.findPostsByTag(tags);
    }

    @GetMapping("posts/period")
    public Iterable<PostDto> findPostsByPeriod(@RequestParam("dateFrom") LocalDate start, @RequestParam("dateTo") LocalDate end) {
        return postService.findPostsByPeriod(start, end);
    }

    @GetMapping("/posts/author/{author}")
    public Iterable<PostDto> findPostsByAuthor(@PathVariable String author) {
        return postService.findPostsByAuthor(author);
    }
}
