package umc.spring.domain.user;

import jakarta.persistence.*;
import lombok.*;
import umc.spring.domain.Alarm.AlarmStatus;
import umc.spring.domain.food.FoodList;
import umc.spring.global.BaseEntity;
import umc.spring.domain.Alarm.Alarm;
import umc.spring.domain.inquiry.Inquiry;
import umc.spring.domain.mission.ProgressingMission;
import umc.spring.domain.review.Review;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Users extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    private LocalDate birth;

    private String address;

    private String phoneNum;

    @Enumerated(EnumType.STRING)
    private UserType userType;

    private String email;

    private Integer point;

    @Enumerated(EnumType.STRING)
    private AlarmStatus pushNewEvent;

    @Enumerated(EnumType.STRING)
    private AlarmStatus pushReviewAnswer;

    @Enumerated(EnumType.STRING)
    private AlarmStatus pushInquiryAnswer;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Alarm> alarmList = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<FoodList> foodListList = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<ProgressingMission> progressingMissionList = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Review> reviewList = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Inquiry> inquiryList = new ArrayList<>();

}
