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
@Table(name="posts")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name = "title")
    @Setter
    private String title;
    @Column(name = "content", columnDefinition = "TEXT")
    @Setter
    private String content;
    @Column(name = "author")
    @Setter
    private String author;
    @Column(name = "date_created")
    private final LocalDateTime dateCreated = LocalDateTime.now();
    @ManyToMany
    @JoinTable(
            name = "post_tags",
            joinColumns = @JoinColumn(name = "posts_id"),
            inverseJoinColumns = @JoinColumn(name = "tags_name")
    )
    private Set<Tag> tags = new HashSet<>();
    @Column(name = "likes")
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
