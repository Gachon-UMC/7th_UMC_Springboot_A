package umc.study.service.UserMissionService;

import org.springframework.data.domain.Page;
import umc.study.domain.Mission;
import umc.study.domain.enums.MissionStatus;
import umc.study.web.dto.MissionCompleteRequestDTO;

public interface UserMissionQueryService {
    Page<Mission> getMissionList(Long userId, MissionStatus status, Integer page);

    void completeMission(MissionCompleteRequestDTO requestDTO);
}
