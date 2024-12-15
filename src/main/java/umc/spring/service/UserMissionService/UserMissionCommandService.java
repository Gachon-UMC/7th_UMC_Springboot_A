package umc.spring.service.UserMissionService;

import umc.spring.web.controller.dto.UserMissionDTO.UserMissionDTO;

public interface UserMissionCommandService {
    UserMissionDTO.MissionUpdateResponseDTO completeMission(Long userMissionId);
}
