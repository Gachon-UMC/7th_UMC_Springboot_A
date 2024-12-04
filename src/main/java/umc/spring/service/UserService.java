package umc.spring.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.domain.mission.ProgressStatus;
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
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public Users createUser(UserRegisterDto request) {
        Users user = usersConverter.toEntity(request);
        user.encodePassword(passwordEncoder.encode(request.getPassword()));
        return usersRepository.save(user);
    }

    @Transactional(readOnly = true)
    public ProgressingMissionResponseDto.MissionListResponseDto getProgressingMissions(Long userId, Integer page, Integer size) {
        Users user = usersRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("유효하지 않은 사용자입니다."));

        Page<ProgressingMission> progressingMissionPage = progressingMissionRepository.findByUserId(user.getId(), PageRequest.of(page, size));

        List<ProgressingMissionResponseDto.MissionPreviewDto> missionList = progressingMissionPage.getContent().stream()
                .filter(progressingMission -> progressingMission.getStatus() != ProgressStatus.COMPLETED) // COMPLETED 제외
                .map(progressingMission -> ProgressingMissionResponseDto.MissionPreviewDto.builder()
                        .description(progressingMission.getMission().getDescription())
                        .missionPoint(progressingMission.getMission().getMissionPoint())
                        .createdAt(progressingMission.getMission().getCreatedAt())
                        .status(progressingMission.getStatus()) // 상태 추가
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
