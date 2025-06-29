package ait.cohort5860.accounting.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
@Getter
@Setter
@ToString
public class UserResponseDto {
    private String login;
    private String firstName;
    private String lastName;
    private List<String> roles;
}
