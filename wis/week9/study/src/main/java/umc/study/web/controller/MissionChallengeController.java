package umc.study.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import umc.study.apiPayload.ApiResponse;
import umc.study.service.UserMissionService.UserMissionCommandService;
import umc.study.service.UserMissionService.UserMissionQueryService;
import umc.study.web.dto.MissionChallengeRequestDTO;
import umc.study.web.dto.MissionChallengeResponseDTO;
import umc.study.web.dto.MissionCompleteRequestDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/missions")
public class MissionChallengeController {

    private final UserMissionCommandService userMissionCommandService;
    private final UserMissionQueryService userMissionQueryService;

    @PostMapping("/challenge")
    public ResponseEntity<MissionChallengeResponseDTO> challengeMission(
            @Valid @RequestBody MissionChallengeRequestDTO request) {
        MissionChallengeResponseDTO response = userMissionCommandService.challengeMission(request);
        return ResponseEntity.ok(response);
    }

    @PatchMapping("/complete")
    @Operation(summary = "진행 중인 미션 완료로 변경 API", description = "진행 중인 미션을 완료로 변경합니다.")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "미션 상태 변경 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "404", description = "유저 또는 미션을 찾을 수 없음"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "400", description = "요청이 유효하지 않음")
    })
    public ApiResponse<String> completeMission(@Valid @RequestBody MissionCompleteRequestDTO requestDTO) {
        userMissionQueryService.completeMission(requestDTO);
        return ApiResponse.onSuccess("Mission successfully completed.");
    }
}
