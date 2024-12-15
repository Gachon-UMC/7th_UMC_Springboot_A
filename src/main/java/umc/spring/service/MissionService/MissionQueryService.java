package umc.spring.service.MissionService;

import umc.spring.web.controller.dto.MissionChallenge.MissionChallengeRequestDTO;
import umc.spring.web.controller.dto.MissionChallenge.MissionChallengeResponseDTO;
import umc.spring.web.controller.dto.MissionDTO.MissionRequestDTO;
import umc.spring.web.controller.dto.MissionDTO.MissionResponseDTO;

public interface MissionQueryService {
    MissionResponseDTO.JoinResultDTO JoinDTO(MissionRequestDTO.JoinAddMissionDTO request);
    MissionChallengeResponseDTO.JoinChallengeResultDTO JoinChallengeDTD(MissionChallengeRequestDTO.JoinAddMissionChallengeDTO result , Long userId);
    MissionResponseDTO.PagedMissionDTO getMissionsByStore(Long storeId, int page);
}
