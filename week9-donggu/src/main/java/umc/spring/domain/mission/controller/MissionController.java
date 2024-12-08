package umc.spring.domain.mission.controller;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import umc.spring.domain.mapping.UserMission;
import umc.spring.domain.mission.converter.MissionConverter;
import umc.spring.domain.mission.domain.Mission;
import umc.spring.domain.mission.dto.MissionRequestDto;
import umc.spring.domain.mission.dto.MissionResponseDto;
import umc.spring.domain.mission.dto.MissionSelectRequestDto;
import umc.spring.domain.mission.service.MissionQueryService;
import umc.spring.domain.mission.service.MissionServiceImpl;
import umc.spring.global.api.ApiResponse;
import umc.spring.global.api.validation.annotation.CheckPage;

@RestController
@Validated
@RequiredArgsConstructor
@RequestMapping("/api/mission")
public class MissionController {

	private final MissionServiceImpl missionService;
	private final MissionQueryService missionQueryService;

	@PostMapping("/{storeId}/add")
	@Operation(summary = "가게에 미션 추가", description = "특정 가게에 미션을 추가합니다.")
	public ApiResponse<MissionResponseDto.addMissionResultDto> addMission(
		@RequestBody @Valid MissionRequestDto request,
		@PathVariable Long storeId) {
		Mission mission = missionService.addMission(request);
		return ApiResponse.onSuccess(MissionConverter.toMissionResponseDto(mission));
	}

	@PostMapping("/{missionId}/select")
	@ApiResponses({
		@io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200",description = "OK, 성공"),
		@io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH003", description = "access 토큰을 주세요!",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
		@io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH004", description = "acess 토큰 만료",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
		@io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH006", description = "acess 토큰 모양이 이상함",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
	})
	@Parameters({
		@Parameter(name = "missionId", description = "미션의 아이디, path variable 입니다!")
	})
	@Operation(summary = "유저 미션 도전", description = "특정 가게의 미션에 도전합니다.")
	public ApiResponse<MissionResponseDto.addUserMissionResultDto> addMission(
		@RequestBody @Valid MissionSelectRequestDto request,
		@PathVariable Long missionId) {
		UserMission userMission = missionService.addUserMission(request);
		return ApiResponse.onSuccess(MissionConverter.toUserMissionResponseDto(userMission));
	}

	@GetMapping("/{storeId}")
	@ApiResponses({
		@io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200",description = "OK, 성공"),
		@io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH003", description = "access 토큰을 주세요!",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
		@io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH004", description = "acess 토큰 만료",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
		@io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH006", description = "acess 토큰 모양이 이상함",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
	})
	@Parameters({
		@Parameter(name = "storeId", description = "가게의 아이디, path variable 입니다!")
	})
	@Operation(summary = "가게의 미션 조회", description = "특정 가게의미션을 조회합니다.")
	public ApiResponse<MissionResponseDto.missionPreviewListDto> getMission(
		@PathVariable(name="storeId") Long storeId,
		@CheckPage @RequestParam(name="page") Integer page) {
		int convertedPage = (page > 0) ? page - 1 : 0;
		return ApiResponse.onSuccess(MissionConverter.missionPreviewListDto(missionQueryService.getMissionList(storeId, convertedPage)));
	}

	@GetMapping("/{userId}/ongoing")
	@ApiResponses({
		@io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200",description = "OK, 성공"),
		@io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH003", description = "access 토큰을 주세요!",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
		@io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH004", description = "acess 토큰 만료",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
		@io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH006", description = "acess 토큰 모양이 이상함",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
	})
	@Parameters({
		@Parameter(name = "userId", description = "유저의 아이디, path variable 입니다!")
	})
	@Operation(summary = "유저의 진행중인 미션 조회", description = "유저의 진행중인 미션을 조회합니다.")
	public ApiResponse<MissionResponseDto.myMissionPreviewListDto> getMyOngoingMission(
		@PathVariable Long userId,
		@CheckPage @RequestParam(name="page") Integer page) {
		int convertedPage = (page > 0) ? page - 1 : 0;
		return ApiResponse.onSuccess(MissionConverter.myMissionPreviewListDto(missionQueryService.getMyOngoingMissionList(userId, convertedPage)));
	}
	@PatchMapping("/mission/{userMissionId}")
	@ApiResponses({
		@io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200",description = "OK, 성공"),
		@io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH003", description = "access 토큰을 주세요!",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
		@io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH004", description = "acess 토큰 만료",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
		@io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH006", description = "acess 토큰 모양이 이상함",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
	})
	@Parameters({
		@Parameter(name = "userMissionId", description = "유저의 미션의 아이디, path variable 입니다!")
	})
	@Operation(summary = "유저의 진행중인 미션을 완료로 변경", description = "유저의 진행중인 미션을 완료로 변경합니다.")
	public ApiResponse<Void> finishMission (
		@PathVariable Long userMissionId){
		missionQueryService.finishMission(userMissionId);
		return ApiResponse.onSuccess(null);
	}
}
