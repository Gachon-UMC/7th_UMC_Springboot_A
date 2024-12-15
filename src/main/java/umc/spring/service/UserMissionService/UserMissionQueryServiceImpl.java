package umc.spring.service.UserMissionService;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.converter.UserMissionConverter;
import umc.spring.domain.User;
import umc.spring.domain.UserMission;
import umc.spring.domain.emums.MissionStatus;
import umc.spring.repository.UserMissionRepository.UserMissionRepository;
import umc.spring.repository.UserRepository.UserRepository;
import umc.spring.web.controller.dto.MissionDTO.UserMissionResponseDTO;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserMissionQueryServiceImpl implements UserMissionQueryService {
    private final UserMissionRepository userMissionRepository;
    private final UserRepository userRepository;

    public UserMissionResponseDTO.PagedMissionDTO getUserMissions(Long userId, int page) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("해당 유저가 존재하지 않습니다."));

        PageRequest pageRequest = PageRequest.of(page, 10); // 한 페이지당 10개
        Page<UserMission> userMissions = userMissionRepository.findByUserAndMissionStatus(user, MissionStatus.PENDING, pageRequest);

        return UserMissionResponseDTO.PagedMissionDTO.builder()
                .missions(userMissions.map(UserMissionConverter::toUserMissionDTO).toList())
                .currentPage(userMissions.getNumber() + 1) // 0-based -> 1-based
                .totalPages(userMissions.getTotalPages())
                .build();
    }
}
