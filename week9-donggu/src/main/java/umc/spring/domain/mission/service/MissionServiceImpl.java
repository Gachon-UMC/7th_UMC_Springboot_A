package umc.spring.domain.mission.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import umc.spring.domain.mapping.UserMission;
import umc.spring.domain.mapping.repository.UserMissionRepository;
import umc.spring.domain.mission.converter.MissionConverter;
import umc.spring.domain.mission.domain.Mission;
import umc.spring.domain.mission.dto.MissionRequestDto;
import umc.spring.domain.mission.dto.MissionSelectRequestDto;
import umc.spring.domain.mission.repository.MissionRepository;
import umc.spring.domain.store.Repository.StoreRepository;
import umc.spring.domain.store.domain.Store;
import umc.spring.domain.user.domain.User;
import umc.spring.domain.user.repository.UserRepository;
import umc.spring.global.api.code.status.ErrorStatus;
import umc.spring.global.api.exception.handler.MissionHandler;
import umc.spring.global.api.exception.handler.StoreHandler;
import umc.spring.global.api.exception.handler.UserHandler;

@Service
@Transactional
@RequiredArgsConstructor
public class MissionServiceImpl implements MissionService {

	private final StoreRepository storeRepository;
	private final MissionRepository missionRepository;
	private final UserRepository userRepository;
	private final UserMissionRepository userMissionRepository;

	@Override
	public Mission addMission(MissionRequestDto request){

		Store store = storeRepository.findById(request.getStoreId())
			.orElseThrow(() -> new StoreHandler(ErrorStatus.STORE_NOT_FOUND));
		Mission newMission = MissionConverter.toMission(request, store);

		store.addMission(newMission);
		newMission.updateMissionLocation(store);

		return missionRepository.save(newMission);
	}

	@Override
	public UserMission addUserMission(MissionSelectRequestDto request){

		Mission mission = missionRepository.findById(request.getMissionId())
			.orElseThrow(() -> new MissionHandler(ErrorStatus.MISSION_NOT_FOUND));

		User user = userRepository.findById(request.getUserId())
			.orElseThrow(() -> new UserHandler(ErrorStatus.USER_NOT_FOUND));

		UserMission newMission = MissionConverter.toUserMission(mission, user);

		return userMissionRepository.save(newMission);
	}
}
