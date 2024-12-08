package umc.study.converter;

import umc.study.domain.UserMission;
import umc.study.web.dto.UserMissionRequestDTO;
import umc.study.web.dto.UserMissionResponseDTO;

public class UserMissionConverter {

    public static UserMissionResponseDTO.JoinUserMissionResultDTO toJoinUserMissionResultDTO(UserMission userMission){
        return UserMissionResponseDTO.JoinUserMissionResultDTO.builder()
                .userMissionId(userMission.getUserMissionId())
                .build();
    }

    public static UserMission toUserMission(UserMissionRequestDTO.JoinUserMissionDto request){
        return UserMission.builder()
                //.userId(request.getUserId())
                //.missionId(request.getMissionId())
                .status(request.getStatus())

                .build();
    }

}