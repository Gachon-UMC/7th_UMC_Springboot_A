package umc.spring.domain.region.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import umc.spring.domain.region.converter.RegionConverter;
import umc.spring.domain.region.domain.Region;
import umc.spring.domain.region.dto.RegionRequestDto;
import umc.spring.domain.region.dto.RegionResponseDto;
import umc.spring.domain.region.service.RegionServiceImpl;
import umc.spring.global.api.ApiResponse;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/regions")
public class RegionController {

	private final RegionServiceImpl regionService;

	//지역 먼저 선택 후 가게를 추가한다는 가정
	@PostMapping("/{regionId}")
	@Operation(summary = "지역에 가게를 추가", description = "특정 지역에 특정 가게를 추가합니다.")
	public ApiResponse<RegionResponseDto.addStoreResultDto> register(
		@RequestBody @Valid RegionRequestDto.addStoreDto request,
		@PathVariable Long regionId) {
		Region region = regionService.addStore(request, regionId);
		return ApiResponse.onSuccess(RegionConverter.toAddStoreResultDto(region));
	}
}
