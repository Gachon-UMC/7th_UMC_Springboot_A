package umc.study.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.study.apiPayload.ApiResponse;
import umc.study.converter.UserMissionConverter;
import umc.study.domain.UserMission;
import umc.study.service.UserMissionService.UserMissionCommandService;
import umc.study.web.dto.UserMissionRequestDTO;
import umc.study.web.dto.UserMissionResponseDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/userMission")
public class UserMissionRestController {

    private final UserMissionCommandService userMissionCommandService;

    @PostMapping("/")
    public ApiResponse<UserMissionResponseDTO.JoinUserMissionResultDTO> join(@RequestBody @Valid UserMissionRequestDTO.JoinUserMissionDto request){
        UserMission userMission = userMissionCommandService.joinUserMission(request);
        return ApiResponse.onSuccess(UserMissionConverter.toJoinUserMissionResultDTO(userMission));
    }
    
}