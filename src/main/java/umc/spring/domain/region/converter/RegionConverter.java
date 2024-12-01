package umc.spring.domain.region.converter;

import java.time.LocalDateTime;

import umc.spring.domain.region.domain.Region;
import umc.spring.domain.region.dto.RegionResponseDto;

public class RegionConverter {

	public static RegionResponseDto.addStoreResultDto toAddStoreResultDto(Region region) {
		return RegionResponseDto.addStoreResultDto.builder()
			.regionId(region.getId())
			.createdAt(LocalDateTime.now())
			.build();
	}
}
