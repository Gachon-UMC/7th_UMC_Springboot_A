package umc.study.service.UserMissionService;

import umc.study.web.dto.MissionChallengeRequestDTO;
import umc.study.web.dto.MissionChallengeResponseDTO;

public interface UserMissionCommandService {
    MissionChallengeResponseDTO challengeMission(MissionChallengeRequestDTO request);
}

