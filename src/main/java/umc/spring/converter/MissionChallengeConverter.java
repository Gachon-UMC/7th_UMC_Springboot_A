    package umc.spring.converter;

    import umc.spring.domain.Store;
    import umc.spring.domain.User;
    import umc.spring.domain.UserMission;
    import umc.spring.domain.emums.MissionStatus;
    import umc.spring.domain.mapping.Mission;
    import umc.spring.web.controller.dto.MissionChallenge.MissionChallengeRequestDTO;
    import umc.spring.web.controller.dto.MissionChallenge.MissionChallengeResponseDTO;

    import java.time.LocalDateTime;

    public class MissionChallengeConverter {

        public static MissionChallengeResponseDTO.JoinChallengeResultDTO ToChallengeDTO(UserMission userMission) {
            return MissionChallengeResponseDTO.JoinChallengeResultDTO.builder()
                    .userMissionId(userMission.getId()) // UserMission의 ID
                    .missionStatus(userMission.getMissionStatus().ordinal())
                    .createdAt(LocalDateTime.now())
                    .build();
        }

        public static UserMission ToUserMission(MissionChallengeRequestDTO.JoinAddMissionChallengeDTO result, User user, Mission mission) {

            return UserMission.builder()
                    .user(user)
                    .mission(mission)
                    .missionStatus(MissionStatus.PENDING)
                    .completedDate(null)
                    .build();


        }

    }
