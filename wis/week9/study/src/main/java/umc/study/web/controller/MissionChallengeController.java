package umc.study.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import umc.study.service.UserMissionService.UserMissionCommandService;
import umc.study.web.dto.MissionChallengeRequestDTO;
import umc.study.web.dto.MissionChallengeResponseDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/missions/challenge")
public class MissionChallengeController {

    private final UserMissionCommandService userMissionCommandService;

    @PostMapping
    public ResponseEntity<MissionChallengeResponseDTO> challengeMission(
            @Valid @RequestBody MissionChallengeRequestDTO request) {
        MissionChallengeResponseDTO response = userMissionCommandService.challengeMission(request);
        return ResponseEntity.ok(response);
    }
}
