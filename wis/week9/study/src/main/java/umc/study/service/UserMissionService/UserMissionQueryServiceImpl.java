package umc.study.service.UserMissionService;

import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.study.apiPayload.exception.GeneralException;
import umc.study.domain.Mission;
import umc.study.domain.User;
import umc.study.domain.enums.MissionStatus;
import umc.study.domain.mapping.UserMission;
import umc.study.repository.UserMissionRepository.UserMissionRepository;
import umc.study.repository.UserRepository.UserRepository;
import umc.study.web.dto.MissionCompleteRequestDTO;

import umc.study.apiPayload.code.status.ErrorStatus;


@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
@Setter
public class UserMissionQueryServiceImpl implements UserMissionQueryService{
    private final UserMissionRepository userMissionRepository;
    private final UserRepository userRepository;

    // 유저가 진행중인 미션 조회
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

    // 진행중인 미션 완료로 바꾸기
    @Override
    @Transactional
    public void completeMission(MissionCompleteRequestDTO requestDTO) {
        // 1. 유저 확인
        User user = userRepository.findById(requestDTO.getUserId())
                .orElseThrow(() -> new GeneralException(ErrorStatus.USER_NOT_FOUND));

        // 2. 진행 중 상태의 미션 조회
        UserMission userMission = userMissionRepository.findByUserAndMissionIdAndStatus(
                user, requestDTO.getMissionId(), MissionStatus.CHALLENGING
        ).orElseThrow(() -> new GeneralException(ErrorStatus.ONGOING_MISSION_NOT_FOUND));

        // 3. 상태를 완료로 변경
        userMission.setStatus(MissionStatus.COMPLETE);

        // 4. 변경사항 저장
        userMissionRepository.save(userMission);
    }
}
