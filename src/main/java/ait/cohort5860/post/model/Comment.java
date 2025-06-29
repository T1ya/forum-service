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
    @Column(name = "id")
    private long id;
    @Column(name = "user_name")
    private String userName;
    @Column(name = "message")
    private String message;
    @Column(name = "date_created")
    private LocalDateTime dateCreated = LocalDateTime.now();
    @Column(name = "likes")
    private long likes;
    @Setter
    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;

    public Comment(String user, String message) {
        this.userName = user;
        this.message = message;
    }

    public void addLikes(long likes) {
        this.likes += likes;
    }
}
