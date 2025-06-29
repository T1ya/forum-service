package ait.cohort5860.accounting.service;

import ait.cohort5860.accounting.dto.UserRegisterDto;
import ait.cohort5860.accounting.dto.UserResponseDto;
import ait.cohort5860.accounting.dto.UserUpdateDto;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {
    @Override
    public UserResponseDto register(UserRegisterDto dto) {
        return null;
    }

    @Override
    public UserResponseDto updateUser(String login, UserUpdateDto dto) {
        return null;
    }

    @Override
    public void deleteUserByLogin(String login) {

    }

    @Override
    public UserResponseDto addRoleToUser(String login, String role) {
        return null;
    }

    @Override
    public UserResponseDto removeRoleFromUser(String login, String role) {
        return null;
    }

    @Override
    public UserResponseDto getUserByLogin(String login) {
        return null;
    }

    @Override
    public void changePassword(String login, String newPassword) {

    }
}
