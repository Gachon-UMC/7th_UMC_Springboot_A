package umc.spring.service.MissionService;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.apiPayload.exception.handler.MissionHandler;
import umc.spring.converter.MissionChallengeConverter;
import umc.spring.converter.MissionConverter;
import umc.spring.domain.Store;
import umc.spring.domain.User;
import umc.spring.domain.UserMission;
import umc.spring.domain.mapping.Mission;
import umc.spring.repository.MissionRepository.MissionRepository;
import umc.spring.repository.StoreRepository.StoreRepository;
import umc.spring.repository.UserMissionRepository.UserMissionRepository;
import umc.spring.repository.UserRepository.UserRepository;
import umc.spring.web.controller.dto.MissionChallenge.MissionChallengeRequestDTO;
import umc.spring.web.controller.dto.MissionChallenge.MissionChallengeResponseDTO;
import umc.spring.web.controller.dto.MissionDTO.MissionRequestDTO;
import umc.spring.web.controller.dto.MissionDTO.MissionResponseDTO;

import static umc.spring.apiPayload.code.status.ErrorStatus.*;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MissionQueryServiceImpl implements MissionQueryService {

    private final MissionRepository missionRepository;
    private final StoreRepository storeRepository;
    private final UserRepository userRepository;
    private final UserMissionRepository userMissionRepository;

    @Override
    @Transactional
    public MissionResponseDTO.JoinResultDTO JoinDTO(MissionRequestDTO.JoinAddMissionDTO request) {

        Store store = storeRepository.findById(request.getStoreId())
                .orElseThrow(()-> new MissionHandler(Mission_STORE_NOT_FOUND));

        Mission mission= MissionConverter.ToMission(request,store);

        Mission newmission = missionRepository.save(mission);

        return MissionConverter.ToMissionDTO(newmission);

    }

    @Override
    @Transactional
    public MissionChallengeResponseDTO.JoinChallengeResultDTO JoinChallengeDTD(MissionChallengeRequestDTO.JoinAddMissionChallengeDTO result , Long userId){

        User user = userRepository.findById(userId)
                .orElseThrow(()-> new MissionHandler(Mission_User_NOT_FOUND));

        Mission mission = missionRepository.findById(result.getMissionId())
                .orElseThrow(()-> new MissionHandler(Mission_NOT_FOUND));

        UserMission userMission = MissionChallengeConverter.ToUserMission(result,user,mission);

        UserMission newUserMission = userMissionRepository.save(userMission);

        newUserMission.startMission();

        userMissionRepository.save(newUserMission);

        return MissionChallengeConverter.ToChallengeDTO(newUserMission);
    }

    public MissionResponseDTO.PagedMissionDTO getMissionsByStore(Long storeId, int page) {
        Store store = storeRepository.findById(storeId)
                .orElseThrow(() -> new IllegalArgumentException("해당 가게가 존재하지 않습니다."));

        PageRequest pageRequest = PageRequest.of(page, 10); // 한 페이지당 10개
        Page<MissionResponseDTO.MissionDTO> missions = missionRepository
                .findByStore(store, pageRequest)
                .map(MissionConverter::toMissionPageDTO);

        return MissionResponseDTO.PagedMissionDTO.builder()
                .missions(missions.getContent())
                .currentPage(missions.getNumber() + 1) // 0-based -> 1-based
                .totalPages(missions.getTotalPages())
                .build();
    }

}


