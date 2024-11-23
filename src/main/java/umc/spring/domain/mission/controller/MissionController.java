package umc.spring.domain.mission.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import umc.spring.domain.mapping.UserMission;
import umc.spring.domain.mission.converter.MissionConverter;
import umc.spring.domain.mission.domain.Mission;
import umc.spring.domain.mission.dto.MissionRequestDto;
import umc.spring.domain.mission.dto.MissionResponseDto;
import umc.spring.domain.mission.dto.MissionSelectRequestDto;
import umc.spring.domain.mission.service.MissionServiceImpl;
import umc.spring.global.api.ApiResponse;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/mission")
public class MissionController {

	private final MissionServiceImpl missionService;

	@PostMapping("/{storeId}/add")
	@Operation(summary = "가게에 미션 추가", description = "특정 가게에 미션을 추가합니다.")
	public ApiResponse<MissionResponseDto.addMissionResultDto> addMission(
		@RequestBody @Valid MissionRequestDto request,
		@PathVariable Long storeId) {
		Mission mission = missionService.addMission(request);
		return ApiResponse.onSuccess(MissionConverter.toMissionResponseDto(mission));
	}

	@PostMapping("/{missionId}/select")
	@Operation(summary = "유저 미션 도전", description = "특정 가게의 미션에 도전합니다.")
	public ApiResponse<MissionResponseDto.addUserMissionResultDto> addMission(
		@RequestBody @Valid MissionSelectRequestDto request,
		@PathVariable Long missionId) {
		UserMission userMission = missionService.addUserMission(request);
		return ApiResponse.onSuccess(MissionConverter.toUserMissionResponseDto(userMission));
	}
}
