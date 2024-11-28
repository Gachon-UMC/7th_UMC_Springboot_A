package umc.study.service.UserMissionService;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.study.domain.Mission;
import umc.study.domain.Review;
import umc.study.domain.Store;
import umc.study.domain.User;
import umc.study.domain.enums.MissionStatus;
import umc.study.domain.mapping.UserMission;
import umc.study.repository.UserMissionRepository.UserMissionRepository;
import umc.study.repository.UserRepository.UserRepository;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserMissionQueryServiceImpl implements UserMissionQueryService{
    private final UserMissionRepository userMissionRepository;
    private final UserRepository userRepository;

    @Override
    public Page<Mission> getMissionList(Long userId, MissionStatus status, Integer page) {
        // 유저 객체 조회
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Page<UserMission> userMissions = userMissionRepository.findAllByUser(
                user, status, PageRequest.of(page, 10)
        );

        // UserMission에서 Mission 객체를 추출하여 반환
        return userMissions.map(UserMission::getMission);
    }
}
