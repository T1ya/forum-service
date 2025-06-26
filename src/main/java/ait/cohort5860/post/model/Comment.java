package ait.cohort5860.post.model;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@EqualsAndHashCode(of = "id")
@Entity
@Table(name="comments")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String userName;
    private String message;
    private LocalDateTime dateCreated = LocalDateTime.now();
    private long likes;
    @Setter
    @ManyToOne
    private Post post;

    public Comment(String user, String message) {
        this.userName = user;
        this.message = message;
    }

    public void addLikes(long likes) {
        this.likes += likes;
    }
}
