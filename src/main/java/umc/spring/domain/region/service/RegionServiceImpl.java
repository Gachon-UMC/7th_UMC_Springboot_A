package umc.spring.domain.region.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import umc.spring.domain.region.domain.Region;
import umc.spring.domain.region.dto.RegionRequestDto;
import umc.spring.domain.region.repository.RegionRepository;
import umc.spring.domain.store.Repository.StoreRepository;
import umc.spring.domain.store.domain.Store;
import umc.spring.global.api.code.status.ErrorStatus;
import umc.spring.global.api.exception.handler.RegionHandler;
import umc.spring.global.api.exception.handler.StoreHandler;

@Service
@Transactional
@RequiredArgsConstructor
public class RegionServiceImpl implements RegionService {
	private final RegionRepository regionRepository;
	private final StoreRepository storeRepository;

	//가게 추가
	@Override
	public Region addStore(RegionRequestDto.addStoreDto request, Long regionId) {

		Region myRegion = regionRepository.findById(regionId)
			.orElseThrow(() -> new RegionHandler(ErrorStatus.REGION_NOT_FOUND));
		Store store = storeRepository.findById(request.getStoreId())
			.orElseThrow(() -> new StoreHandler(ErrorStatus.STORE_NOT_FOUND));

		store.updateRegion(myRegion);
		myRegion.addStore(store);
		return regionRepository.save(myRegion);
	}
}
