package umc.study.service.UserMissionService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.study.domain.Mission;
import umc.study.domain.User;
import umc.study.domain.enums.MissionStatus;
import umc.study.domain.mapping.UserMission;
import umc.study.repository.MissionRepository.MissionRepository;
import umc.study.repository.UserMissionRepository.UserMissionRepository;
import umc.study.repository.UserRepository.UserRepository;
import umc.study.web.dto.MissionChallengeRequestDTO;
import umc.study.web.dto.MissionChallengeResponseDTO;

@Service
@RequiredArgsConstructor
public class UserMissionCommandServiceImpl implements UserMissionCommandService {

    private final UserRepository userRepository;
    private final MissionRepository missionRepository;
    private final UserMissionRepository userMissionRepository;

    @Override
    @Transactional
    public MissionChallengeResponseDTO challengeMission(MissionChallengeRequestDTO request) {

        User user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found")); // Custom exception recommended

        Mission mission = missionRepository.findById(request.getMissionId())
                .orElseThrow(() -> new RuntimeException("Mission not found")); // Custom exception recommended

        UserMission userMission = UserMission.builder()
                .user(user)
                .mission(mission)
                .status(MissionStatus.CHALLENGING)
                .verificationCode(generateVerificationCode())
                .build();

        userMissionRepository.save(userMission);

        return MissionChallengeResponseDTO.builder()
                .userId(user.getId())
                .missionId(mission.getId())
                .status(MissionStatus.CHALLENGING.name())
                .build();
    }

    private Long generateVerificationCode() {
        return (long) (Math.random() * 1_000_000); // Random 6-digit verification code
    }
}

