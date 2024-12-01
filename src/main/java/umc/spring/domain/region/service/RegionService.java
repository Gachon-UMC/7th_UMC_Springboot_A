package umc.spring.domain.region.service;

import umc.spring.domain.region.domain.Region;
import umc.spring.domain.region.dto.RegionRequestDto;

public interface RegionService {
	 Region addStore(RegionRequestDto.addStoreDto request, Long regionId);
}
