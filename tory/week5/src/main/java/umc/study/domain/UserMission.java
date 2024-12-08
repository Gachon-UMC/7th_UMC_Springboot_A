package umc.study.domain;

import jakarta.persistence.*;
import lombok.*;
import umc.study.domain.enums.MissionStatus;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class UserMission{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userMissionId;


    private Long verificationCode;

    @Enumerated(EnumType.STRING)
    private MissionStatus status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mission_id")
    private Mission mission;

    public void updateMissionStatus(){
        this.status=MissionStatus.COMPLETE;
    }
}