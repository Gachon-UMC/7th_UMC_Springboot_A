package umc.study.service.ReviewService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.study.converter.MissionConverter;
import umc.study.domain.Mission;
import umc.study.domain.Review;
import umc.study.repository.MissionRepository.MissionRepository;
import umc.study.service.MissionService.MissionCommandService;
import umc.study.web.dto.MissionRequestDTO;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class MissionCommandServiceImpl implements MissionCommandService {

    private final MissionRepository missionRepository;

    @Override
    public Review MissionReview(MissionRequestDTO.JoinMissionDto request) {
        return null;
    }

    @Override
    @Transactional
    public Mission joinMission(MissionRequestDTO.JoinMissionDto request) {

        Mission newMission = MissionConverter.toMission(request);
        newMission.setCreatedAt(LocalDateTime.now());
        newMission.setUpdatedAt(LocalDateTime.now());

        return missionRepository.save(newMission);
    }
}