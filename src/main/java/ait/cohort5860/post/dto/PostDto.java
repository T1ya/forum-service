package ait.cohort5860.post.dto;

import lombok.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Builder
public class PostDto {
        private long id;
        private String title;
        private String content;
        private String author;
        private LocalDateTime dateCreated;
        @Singular
        private Set<String> tags;
        private long likes;
        @Singular
        private List<CommentDto> comments;
}
