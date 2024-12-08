package umc.study.service.MissionService;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.study.domain.Mission;
import umc.study.domain.Review;
import umc.study.web.dto.MissionRequestDTO;

@Service
public interface MissionCommandService {

    Review MissionReview(MissionRequestDTO.JoinMissionDto request);

    @Transactional
    Mission joinMission(MissionRequestDTO.JoinMissionDto request);
}