package umc.study.service.UserMissionService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.study.converter.UserMissionConverter;
import umc.study.domain.UserMission;
import umc.study.repository.UserMissionRepository.UserMissionRepository;
import umc.study.web.dto.UserMissionRequestDTO;

@Service
@RequiredArgsConstructor
public class UserMissionCommandServiceImpl implements UserMissionCommandService {

    private final UserMissionRepository userMissionRepository;

    @Override
    public UserMission joinStore(UserMissionRequestDTO.JoinUserMissionDto request) {
        return null;
    }

    @Override
    @Transactional
    public UserMission joinUserMission(UserMissionRequestDTO.JoinUserMissionDto request) {

        UserMission newUserMission = UserMissionConverter.toUserMission(request);

        return userMissionRepository.save(newUserMission);
    }
}