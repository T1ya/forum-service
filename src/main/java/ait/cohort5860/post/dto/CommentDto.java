package ait.cohort5860.post.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CommentDto {
        @JsonProperty("user")
        private String user;
        private String message;
        private LocalDateTime dateCreated;
        private long likes;
}
