package ait.cohort5860.post.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class AddCommentDto {
    @JsonProperty("message")
    @NotBlank(message = "comment should not be empty")
    @Size(min = 3, max = 200, message = "comment must be between 3 and 200 characters")
    private String comment;
}
