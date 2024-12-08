package umc.study.domain;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import umc.study.domain.enums.Gender;
import umc.study.domain.enums.Role;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@DynamicInsert
@DynamicUpdate
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;

    private String name;

    @Enumerated(EnumType.STRING)
    private Gender gender;

//    @Column(columnDefinition = "DEFAULT 'ACTIVE'")
//    private UserStatus userStatus;



    private String address;


    private String preferFoodCategory;

    @CreatedDate
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime updatedAt;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

    public void encodePassword(String password) {
        this.password = password;
    }
    @OneToMany(mappedBy = "user",cascade=CascadeType.ALL)
    private List<Review> reviewList=new ArrayList<>();
    @OneToMany(mappedBy = "user",cascade=CascadeType.ALL)
    private List<UserMission> userMissionList=new ArrayList<>();

    @OneToMany(mappedBy = "user",cascade=CascadeType.ALL)
    private List<Mission> missionList=new ArrayList<>();

    @OneToMany(mappedBy = "user",cascade=CascadeType.ALL)
    private List<UserPrefer> userPreferList=new ArrayList<>();
}