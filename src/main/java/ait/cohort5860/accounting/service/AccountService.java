package ait.cohort5860.accounting.service;

import ait.cohort5860.accounting.dto.UserRegisterDto;
import ait.cohort5860.accounting.dto.UserResponseDto;
import ait.cohort5860.accounting.dto.UserUpdateDto;

public interface AccountService {
    UserResponseDto register(UserRegisterDto dto);
    UserResponseDto updateUser(String login, UserUpdateDto dto);
    void deleteUserByLogin(String login);
    UserResponseDto addRoleToUser(String login, String role);
    UserResponseDto removeRoleFromUser(String login, String role);
    UserResponseDto getUserByLogin(String login);
    void changePassword(String login, String newPassword);
}