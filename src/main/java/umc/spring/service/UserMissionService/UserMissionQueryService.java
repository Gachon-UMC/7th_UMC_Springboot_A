package umc.spring.service.UserMissionService;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import umc.spring.domain.User;
import umc.spring.domain.UserMission;
import umc.spring.domain.emums.MissionStatus;
import umc.spring.web.controller.dto.MissionDTO.UserMissionResponseDTO;


public interface UserMissionQueryService  {
    UserMissionResponseDTO.PagedMissionDTO getUserMissions(Long userId, int page);

}
