package umc.spring.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import umc.spring.Vaildator.annotation.CheckPage;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.service.UserMissionService.UserMissionCommandService;
import umc.spring.service.UserMissionService.UserMissionQueryService;
import umc.spring.web.controller.dto.MissionDTO.UserMissionResponseDTO;
import umc.spring.web.controller.dto.UserMissionDTO.UserMissionDTO;

@RestController
@RequiredArgsConstructor
@Validated
@RequestMapping("/users")
public class UserMissionController {

    private final UserMissionQueryService userMissionQueryService;
    private final UserMissionCommandService userMissionCommandService;

    @GetMapping("/{userId}/missions")
    @Operation(summary = "내가 진행 중인 미션 목록 조회 API", description = "특정 유저가 진행 중인 미션 목록을 페이징 처리하여 반환합니다.")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "미션 목록 조회 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "404", description = "유저가 존재하지 않음"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "400", description = "페이지 번호가 잘못됨")
    })
    @Parameters({
            @Parameter(name = "userId", description = "유저 ID, PathVariable로 전달됩니다.", required = true),
            @Parameter(name = "page", description = "페이지 번호, Query String으로 전달됩니다.", required = true)
    })
    public ApiResponse<UserMissionResponseDTO.PagedMissionDTO> getUserMissions(
            @PathVariable Long userId,
            @CheckPage @RequestParam(name = "page", defaultValue = "1") Integer page) {
        UserMissionResponseDTO.PagedMissionDTO response = userMissionQueryService.getUserMissions(userId, page - 1);
        return ApiResponse.onSuccess(response);
    }



    @PatchMapping("/{userMissionId}/complete")
    @Operation(summary = "진행 중인 미션 완료로 변경 API", description = "특정 유저의 진행 중인 미션 상태를 완료로 변경합니다.")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "미션 상태 변경 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "404", description = "유저 미션이 존재하지 않음"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "400", description = "이미 완료된 미션")
    })
    @Parameters({
            @Parameter(name = "userMissionId", description = "유저 미션 ID", required = true)
    })
    public ApiResponse<UserMissionDTO.MissionUpdateResponseDTO> completeMission(
            @PathVariable Long userMissionId) {
        UserMissionDTO.MissionUpdateResponseDTO response = userMissionCommandService.completeMission(userMissionId);
        return ApiResponse.onSuccess(response);
    }


}
