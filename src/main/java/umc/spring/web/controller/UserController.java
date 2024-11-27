package umc.spring.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import umc.spring.domain.user.Users;
import umc.spring.dto.UserRegisterDto;
import umc.spring.service.UserService;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<Users> createUser(@Validated @RequestBody UserRegisterDto request) {
        Users createdUser = userService.createUser(request);
        return ResponseEntity.ok(createdUser);
    }
}
