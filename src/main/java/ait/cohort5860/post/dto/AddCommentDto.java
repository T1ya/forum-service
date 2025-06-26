package ait.cohort5860.post.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class AddCommentDto {
    @JsonProperty("message")
    private String comment;
}
