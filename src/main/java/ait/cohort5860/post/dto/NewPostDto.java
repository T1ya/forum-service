package ait.cohort5860.post.dto;

import lombok.Data;

import java.util.Set;

@Data
public class NewPostDto {
    	private String title;
        private String content;
        private Set<String> tags;
}
