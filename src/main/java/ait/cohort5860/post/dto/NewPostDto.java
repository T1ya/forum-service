package ait.cohort5860.post.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.Set;

@Data
public class NewPostDto {
    @NotBlank(message = "title is required")
    @Size(min = 3, max = 20, message = "title must be between 3 and 20 characters")
    private String title;
    @NotBlank(message = "Post content is empty")
    @Size(min = 1, max = 250, message = "Post content must be between 1 and 250 characters")
    private String content;
    @Size(min = 1, max = 10, message = "each post should have from 1 to 10 tags")
    private Set<@Size(min = 1, max = 5, message = "tag should be between 1 and 5 characters") String> tags;
}
