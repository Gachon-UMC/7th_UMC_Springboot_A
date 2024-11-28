package umc.spring.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.converter.ProgressingMissionConverter;
import umc.spring.domain.mission.Mission;
import umc.spring.domain.mission.ProgressingMission;
import umc.spring.domain.user.Users;
import umc.spring.web.dto.ProgressingMissionRegisterDto;
import umc.spring.repository.MissionRepository;
import umc.spring.repository.ProgressingMissionRepository;
import umc.spring.repository.UsersRepository;
import umc.spring.web.dto.ProgressingMissionResponseDto;

@Service
@RequiredArgsConstructor
public class ProgressingMissionService {

    private final ProgressingMissionRepository progressingMissionRepository;
    private final MissionRepository missionRepository;
    private final UsersRepository usersRepository;
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
