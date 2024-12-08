package umc.study.service.UserMissionService;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.study.domain.UserMission;
import umc.study.web.dto.UserMissionRequestDTO;

@Service
public interface UserMissionCommandService {

    UserMission joinStore(UserMissionRequestDTO.JoinUserMissionDto request);

    @Transactional
    UserMission joinUserMission(UserMissionRequestDTO.JoinUserMissionDto request);
}