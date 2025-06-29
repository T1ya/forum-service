package ait.cohort5860.post.service;

import ait.cohort5860.post.dao.PostRepository;
import ait.cohort5860.post.dao.TagRepository;
import ait.cohort5860.post.dto.AddCommentDto;
import ait.cohort5860.post.dto.NewPostDto;
import ait.cohort5860.post.dto.PostDto;
import ait.cohort5860.post.dto.exceptions.PostDtoException;
import ait.cohort5860.post.model.Comment;
import ait.cohort5860.post.model.Post;
import ait.cohort5860.post.model.Tag;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;
    private final ModelMapper modelMapper;
    private final TagRepository tagRepository;

    @Override
    @Transactional
    public PostDto addPost(String author, NewPostDto newPostDto) {
        Post post = new Post(newPostDto.getTitle(), newPostDto.getContent(), author);
        Set<String> tags = newPostDto.getTags();
        // Handle tags
        if (tags != null && !tags.isEmpty()) {
            for (String tagName : tags) {
                Tag tag = tagRepository.findById(tagName).orElseGet(() -> tagRepository.save(new Tag(tagName)));
                post.addTag(tag);
            }
        }

        post =  postRepository.save(post);
        return modelMapper.map(post, PostDto.class);
    }

    @Override
    public PostDto findPostById(long postId) {
        Post post = postRepository.findById(postId).orElseThrow(PostDtoException::new);
        return modelMapper.map(post, PostDto.class);
    }

    @Override
    @Transactional
    public void addLike(long postId) {
        Post post = postRepository.findById(postId).orElseThrow(PostDtoException::new);
        post.addLikes();
        postRepository.save(post);
    }

    @Override
    @Transactional
    public PostDto updatePost(long id, NewPostDto newPostDto) {
        Post post = postRepository.findById(id).orElseThrow(PostDtoException::new);
        if(newPostDto.getTitle()!= null) post.setTitle(newPostDto.getTitle());
        if(newPostDto.getContent()!= null) post.setContent(newPostDto.getContent());
        Set<String> tags = newPostDto.getTags();
        // Handle tags
        post.getTags().clear();
        if (tags != null && !tags.isEmpty()) {
            for (String tagName : tags) {
                Tag tag = tagRepository.findById(tagName).orElseGet(() -> tagRepository.save(new Tag(tagName)));
                post.addTag(tag);
            }
        }
        return modelMapper.map(post, PostDto.class);
    }


    @Override
    @Transactional
    public PostDto addComment(long postId, String author, AddCommentDto addCommentDto) {
        Post post = postRepository.findById(postId).orElseThrow(PostDtoException::new);
        Comment comment = new Comment(author, addCommentDto.getComment());
        post.addComment(comment);
        postRepository.save(post);
        return modelMapper.map(post, PostDto.class);
    }

    @Override
    @Transactional
    public PostDto deletePost(long postId) {
        Post post = postRepository.findById(postId).orElseThrow(PostDtoException::new);
        PostDto postDto = modelMapper.map(post, PostDto.class);
        postRepository.delete(post);
        return postDto;
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<PostDto> findPostsByTag(Set<String> tags) {
        return postRepository.findDistinctByTagsIgnoreCase_NameIn(tags)
                .map(post -> modelMapper.map(post, PostDto.class))
                .toList();
    }

    @Override
    public Iterable<PostDto> findPostsByPeriod(LocalDate start, LocalDate end) {
        return postRepository.findAllByDateCreatedBetween(start.atStartOfDay(),end.plusDays(1).atStartOfDay())
                .map(post -> modelMapper.map(post, PostDto.class)).toList();

    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<PostDto> getPostsByAuthor(String author) {
        return postRepository.findAllByAuthorIgnoreCase(author)
                .map(post -> modelMapper.map(post, PostDto.class)).toList();
    }
}
