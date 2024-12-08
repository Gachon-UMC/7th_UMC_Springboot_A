package umc.spring.domain.mission.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import umc.spring.domain.mapping.UserMission;
import umc.spring.domain.mapping.repository.UserMissionRepository;
import umc.spring.domain.mission.domain.Mission;
import umc.spring.domain.mission.repository.MissionRepository;
import umc.spring.domain.store.Repository.StoreRepository;
import umc.spring.domain.store.domain.Store;
import umc.spring.domain.user.domain.User;
import umc.spring.domain.user.repository.UserRepository;
import umc.spring.global.api.code.status.ErrorStatus;
import umc.spring.global.api.exception.handler.MissionHandler;

@Service
@Transactional
@RequiredArgsConstructor
public class MissionQueryServiceImpl implements MissionQueryService {

	private final MissionRepository missionRepository;
	private final StoreRepository storeRepository;
	private final UserRepository userRepository;
	private final UserMissionRepository userMissionRepository;

	@Override
	public Page<Mission> getMissionList (Long storeId, Integer page){
		Store store = storeRepository.findById(storeId).get();

		Page<Mission> missionPage = missionRepository.findAllByStore(store, PageRequest.of(page, 10));
		return missionPage;
	}

	@Override
	public Page<UserMission> getMyOngoingMissionList (Long userId, Integer page){
		User user =userRepository.findById(userId).get();

		Page<UserMission> myMissionPage = userMissionRepository.findAllByUserAndMissionStatus(user, PageRequest.of(page, 10));
		return myMissionPage;
	}

	@Override
	public Void finishMission(Long userMissionId) {
		UserMission target = userMissionRepository.findById(userMissionId)
			.orElseThrow(()-> new MissionHandler(ErrorStatus.MISSION_NOT_FOUND));

		 target.finishMissionStatus();
		 userMissionRepository.save(target);
		 return null;
	}
}
