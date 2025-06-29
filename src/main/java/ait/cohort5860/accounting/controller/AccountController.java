package ait.cohort5860.accounting.controller;

import ait.cohort5860.accounting.dto.UserRegisterDto;
import ait.cohort5860.accounting.dto.UserResponseDto;
import ait.cohort5860.accounting.dto.UserUpdateDto;
import ait.cohort5860.accounting.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("/account")
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;

    @PostMapping("/register")
    public ResponseEntity<UserResponseDto> register(@RequestBody UserRegisterDto dto) {
        return ResponseEntity.ok(accountService.register(dto));
    }

    @PatchMapping("/user/{login}")
    public ResponseEntity<UserResponseDto> updateUser(
            @PathVariable String login,
            @RequestBody UserUpdateDto dto) {
        return ResponseEntity.ok(accountService.updateUser(login, dto));
    }

    @DeleteMapping("/user/{login}")
    public ResponseEntity<Void> deleteUser(@PathVariable String login) {
        accountService.deleteUserByLogin(login);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/user/{login}/role/{role}")
    public ResponseEntity<UserResponseDto> addRole(@PathVariable String login, @PathVariable String role) {
        return ResponseEntity.ok(accountService.addRoleToUser(login, role));
    }

    @DeleteMapping("/user/{login}/role/{role}")
    public ResponseEntity<UserResponseDto> removeRole(@PathVariable String login, @PathVariable String role) {
        return ResponseEntity.ok(accountService.removeRoleFromUser(login, role));
    }

    @GetMapping("/user/{login}")
    public ResponseEntity<UserResponseDto> getUser(@PathVariable String login) {
        return ResponseEntity.ok(accountService.getUserByLogin(login));
    }

    @PatchMapping("/password")
    public ResponseEntity<Void> changePassword(
            @RequestHeader("X-Password") String newPassword,
            Principal principal) {
        accountService.changePassword(principal.getName(), newPassword);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(Principal principal) {
        return ResponseEntity.ok("Login successful for user: " + principal.getName());
    }
}

