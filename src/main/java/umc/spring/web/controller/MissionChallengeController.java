package umc.spring.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.service.MissionService.MissionQueryService;
import umc.spring.service.MissionService.MissionQueryServiceImpl;
import umc.spring.web.controller.dto.MissionChallenge.MissionChallengeRequestDTO;
import umc.spring.web.controller.dto.MissionChallenge.MissionChallengeResponseDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/mission")
public class MissionChallengeController {


    private final MissionQueryService missionService;

    @PostMapping("/{userId}/challenge")
    public ApiResponse<MissionChallengeResponseDTO.JoinChallengeResultDTO> challengeMission(
            @PathVariable Long userId,
            @RequestBody @Valid MissionChallengeRequestDTO.JoinAddMissionChallengeDTO request) {

        // MissionQueryServiceImpl의 JoinChallengeDTD 호출
        MissionChallengeResponseDTO.JoinChallengeResultDTO result = missionService.JoinChallengeDTD(request, userId);

        // 성공적인 응답 반환
        return ApiResponse.onSuccess(result);
    }
}
