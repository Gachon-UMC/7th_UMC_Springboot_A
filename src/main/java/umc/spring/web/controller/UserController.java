package umc.spring.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import umc.spring.domain.user.Users;
import umc.spring.dto.UserRegisterDto;
import umc.spring.service.UserService;
import umc.spring.validation.CheckPage;
import umc.spring.web.dto.ProgressingMissionResponseDto;

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

    @GetMapping("/{userId}/missions/progressing")
    public ResponseEntity<ProgressingMissionResponseDto.MissionListResponseDto> getProgressingMissions(
            @PathVariable(name = "userId") Long userId,
            @CheckPage @RequestParam(name = "page") Integer page,
            @RequestParam(name = "size", defaultValue = "10") Integer size) {
        ProgressingMissionResponseDto.MissionListResponseDto response = userService.getProgressingMissions(userId, page - 1, size);
        return ResponseEntity.ok(response);
    }
}
