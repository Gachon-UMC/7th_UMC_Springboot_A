package umc.study.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.study.apiPayload.ApiResponse;
import umc.study.converter.MissionConverter;
import umc.study.domain.Mission;
import umc.study.service.MissionService.MissionCommandService;
import umc.study.web.dto.MissionRequestDTO;
import umc.study.web.dto.MissionResponseDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/mission")
public class MissionRestController {

    private final MissionCommandService missionCommandService;


    @PostMapping("/")
    public ApiResponse<MissionResponseDTO.JoinMissionResultDTO> join(@RequestBody MissionRequestDTO.JoinMissionDto request){
        Mission mission = missionCommandService.joinMission(request);
        return ApiResponse.onSuccess(MissionConverter.toJoinMissionResultDTO(mission));
    }

}