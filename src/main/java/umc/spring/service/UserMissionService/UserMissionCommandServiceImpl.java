package umc.spring.service.UserMissionService;


import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.spring.apiPayload.exception.handler.MissionHandler;
import umc.spring.converter.UserMissionConverter;
import umc.spring.domain.UserMission;
import umc.spring.domain.emums.MissionStatus;
import umc.spring.repository.UserMissionRepository.UserMissionRepository;
import umc.spring.web.controller.dto.UserMissionDTO.UserMissionDTO;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
@Transactional
public class UserMissionCommandServiceImpl implements UserMissionCommandService {
    private final UserMissionRepository userMissionRepository;


    public UserMissionDTO.MissionUpdateResponseDTO completeMission(Long userMissionId) {
        // 유저 미션 조회
        UserMission userMission = userMissionRepository.findById(userMissionId)
                .orElseThrow(() -> new IllegalArgumentException("유저 미션이 존재하지 않습니다."));

        // 미션 상태가 PENDING인지 확인
        if (userMission.getMissionStatus() != MissionStatus.PENDING) {
            throw new IllegalArgumentException("이미 완료된 미션입니다.");
        }

        // 상태를 변경한 새 UserMission 객체 생성
        UserMission updatedMission = UserMissionConverter.updateMissionStatus(userMission, MissionStatus.COMPLETED, LocalDateTime.now());

        // 업데이트된 객체를 저장
        userMissionRepository.save(updatedMission);

        // 반환 DTO 생성
        return UserMissionConverter.toMissionUpdateDTO(updatedMission);
    }
}
