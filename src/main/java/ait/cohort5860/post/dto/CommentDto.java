package ait.cohort5860.post.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CommentDto {
        private String user;
        private String message;
        private LocalDateTime dateCreated;
        private long likes;
}
