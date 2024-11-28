package umc.spring.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.domain.mission.ProgressingMission;
import umc.spring.domain.user.Users;
import umc.spring.dto.UserRegisterDto;
import umc.spring.repository.ProgressingMissionRepository;
import umc.spring.repository.UsersRepository;
import umc.spring.converter.UsersConverter;
import umc.spring.web.dto.ProgressingMissionResponseDto;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UsersRepository usersRepository;
    private final UsersConverter usersConverter;
    private final ProgressingMissionRepository progressingMissionRepository;

    @Transactional
    public Users createUser(UserRegisterDto request) {
        Users user = usersConverter.toEntity(request);
        return usersRepository.save(user);
    }

    @Transactional(readOnly = true)
    public ProgressingMissionResponseDto.MissionListResponseDto getProgressingMissions(Long userId, Integer page, Integer size) {
        Users user = usersRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("유효하지 않은 사용자입니다."));

        Page<ProgressingMission> progressingMissionPage = progressingMissionRepository.findByUserId(user.getId(), PageRequest.of(page, size));

        List<ProgressingMissionResponseDto.MissionPreviewDto> missionList = progressingMissionPage.getContent().stream()
                .map(progressingMission -> ProgressingMissionResponseDto.MissionPreviewDto.builder()
                        .description(progressingMission.getMission().getDescription()) // 미션 설명
                        .missionPoint(progressingMission.getMission().getMissionPoint()) // 미션 포인트
                        .createdAt(progressingMission.getMission().getCreatedAt()) // 생성일
                        .build())
                .toList();

        return ProgressingMissionResponseDto.MissionListResponseDto.builder()
                .missionList(missionList)
                .listSize(missionList.size())
                .totalPage(progressingMissionPage.getTotalPages())
                .totalElements(progressingMissionPage.getTotalElements())
                .isFirst(progressingMissionPage.isFirst())
                .isLast(progressingMissionPage.isLast())
                .build();
    }
}
