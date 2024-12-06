package umc.study.service.MissionService;

import umc.study.web.dto.MissionRequestDTO;
import umc.study.web.dto.MissionResponseDTO;

public interface MissionCommandService {
    MissionResponseDTO addMission(Long storeId, MissionRequestDTO request);
}
