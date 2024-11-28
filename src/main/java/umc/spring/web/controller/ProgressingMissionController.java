package umc.spring.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import umc.spring.converter.ProgressingMissionConverter;
import umc.spring.domain.mission.Mission;
import umc.spring.domain.mission.ProgressingMission;
import umc.spring.domain.user.Users;
import umc.spring.repository.MissionRepository;
import umc.spring.repository.ProgressingMissionRepository;
import umc.spring.repository.UsersRepository;
import umc.spring.web.dto.ProgressingMissionRegisterDto;
import umc.spring.service.ProgressingMissionService;
import umc.spring.web.dto.ProgressingMissionResponseDto;

@RestController
@RequestMapping("/progressing-missions")
@RequiredArgsConstructor
public class ProgressingMissionController {

    private final UsersRepository usersRepository;
    private final MissionRepository missionRepository;
    private final ProgressingMissionRepository progressingMissionRepository;
    private final ProgressingMissionConverter progressingMissionConverter;


    @Transactional
    public ProgressingMissionResponseDto.MissionPreviewDto addProgressingMission(ProgressingMissionRegisterDto dto) {
        Users user = usersRepository.findById(dto.getUserId())
                .orElseThrow(() -> new IllegalArgumentException("유효하지 않은 사용자입니다."));

        Mission mission = missionRepository.findById(dto.getMissionId())
                .orElseThrow(() -> new IllegalArgumentException("유효하지 않은 미션입니다."));

        ProgressingMission progressingMission = progressingMissionConverter.toEntity(user, mission);
        progressingMissionRepository.save(progressingMission);

        // MissionPreviewDto 반환
        return ProgressingMissionResponseDto.MissionPreviewDto.builder()
                .description(mission.getDescription())
                .missionPoint(mission.getMissionPoint())
                .createdAt(mission.getCreatedAt())
                .build();
    }

}
