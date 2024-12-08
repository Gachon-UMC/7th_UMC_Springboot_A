package umc.study.domain;

import jakarta.persistence.*;
import lombok.*;
import umc.study.domain.common.BaseEntity;
import umc.study.domain.enums.*;
import umc.study.domain.mapping.UserAgree;
import umc.study.domain.mapping.UserMission;
import umc.study.domain.mapping.UserPrefer;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class User extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    private String email;

    @Column(nullable = false, length = 10)
    private String name;

    @Column(nullable = false, length = 10)
    @Enumerated(EnumType.STRING)
    private Gender gender;

    private LocalDate birthday;

    @Column(nullable = false, length = 255)
    private String address;

    private LocalDate lastLogin;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "VARCHAR(15) DEFAULT 'ACTIVE'")
    private UserStatus status;

    private LocalDate inactiveDate;

    @Enumerated(EnumType.STRING)
    private SocialType socialType;

    private Integer point;

    @Column(nullable = false, length = 20)
    private String phone;

    @Column(nullable = false)
    private boolean phoneVerified;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<UserAgree> userAgreeList = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<UserPrefer> userPreferList = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Review> reviewList = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<UserMission> userMissionList = new ArrayList<>();

}