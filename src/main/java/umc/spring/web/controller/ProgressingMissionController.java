package umc.spring.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import umc.spring.web.dto.ProgressingMissionRegisterDto;
import umc.spring.service.ProgressingMissionService;
import umc.spring.web.dto.ProgressingMissionResponseDto;

@RestController
@RequestMapping("/progressing-missions")
@RequiredArgsConstructor
public class ProgressingMissionController {

    private final ProgressingMissionService progressingMissionService;

    @PostMapping
    public ResponseEntity<ProgressingMissionResponseDto> registerProgressingMission(
            @Valid @RequestBody ProgressingMissionRegisterDto dto,
            @RequestParam(name = "userId", required = true) Long userId) {
        dto.setUserId(userId); // DTO에 userId 설정
        ProgressingMissionResponseDto responseDto = progressingMissionService.addProgressingMission(dto);
        return ResponseEntity.ok(responseDto);
    }
}
