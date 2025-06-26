package ait.cohort5860.post.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="post")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Setter
    private String title;
    @Setter
    private String content;
    @Setter
    private String author;
    private final LocalDateTime dateCreated = LocalDateTime.now();
    @ManyToMany
    private Set<Tag> tags = new HashSet<>();
    private int likes;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "post", orphanRemoval = true)
    private List<Comment> comments = new ArrayList<>();

    public Post(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void addComment(Comment comment) {
        comment.setPost(this);
        comments.add(comment);
    }

    public void addLikes() {
        this.likes++;
    }

    public boolean addTag(Tag tag) {
        return tags.add(tag);
    }
}
