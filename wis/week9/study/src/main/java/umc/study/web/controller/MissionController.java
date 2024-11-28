package umc.study.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import umc.study.service.MissionService.MissionCommandService;
import umc.study.web.dto.MissionRequestDTO;
import umc.study.web.dto.MissionResponseDTO;

@RestController
@RequestMapping("/stores/{storeId}/missions")
@RequiredArgsConstructor
public class MissionController {

    private final MissionCommandService missionCommandService;

    @PostMapping
    public ResponseEntity<MissionResponseDTO> addMission(
            @PathVariable Long storeId,
            @RequestBody @Valid MissionRequestDTO request) {
        MissionResponseDTO mission = missionCommandService.addMission(storeId, request);
        return ResponseEntity.status(HttpStatus.CREATED).body(mission);
    }
}

