package umc.spring.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import umc.spring.domain.mission.Mission;
import umc.spring.web.dto.MissionRegisterDto;
import umc.spring.service.MissionService;

@RestController
@RequestMapping("/missions")
@RequiredArgsConstructor
public class MissionController {

    private final MissionService missionService;

    @PostMapping
    public ResponseEntity<Mission> registerMission(
            @Valid @RequestBody MissionRegisterDto dto) {
        Mission createdMission = missionService.addMission(dto);
        return ResponseEntity.ok(createdMission);
    }
}
