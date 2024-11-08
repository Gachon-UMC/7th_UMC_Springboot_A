package umc.spring.domain.user.domain;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotNull;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import umc.spring.domain.mapping.UserAgree;
import umc.spring.domain.mapping.UserMission;
import umc.spring.domain.mapping.UserPrefer;
import umc.spring.domain.notification.domain.Notification;
import umc.spring.domain.point.domain.Point;
import umc.spring.domain.reply.domain.Reply;
import umc.spring.domain.review.domain.Review;
import umc.spring.domain.shared.BaseTimeEntity;
import umc.spring.domain.shared.Gender;
import umc.spring.domain.shared.SocialStatus;
import umc.spring.domain.shared.UserStatus;
import umc.spring.domain.shared.UserType;

@Entity(name = "users")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User extends BaseTimeEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userId;

	@NotNull
	@Column(length = 10)
	private String customId;

	@NotNull
	@Column(length = 20)
	private String password;

	@NotNull
	@Column(length = 10)
	private String userName;

	@NotNull
	@Column(columnDefinition = "VARCHAR(10)")
	@Enumerated(EnumType.STRING)
	private UserType userType;

	@Column(length = 10)
	private String nickname;

	@NotNull
	@Column(columnDefinition = "VARCHAR(10) DEFAULT 'ACTIVE'")
	@Enumerated(EnumType.STRING)
	private UserStatus userStatus;

	@Column
	private LocalDateTime inactiveDate;

	@Embedded
	private BirthDay birth;

	@NotNull
	@Column(columnDefinition = "VARCHAR(10)")
	@Enumerated(EnumType.STRING)
	private Gender gender;

	@NotNull
	@Column(length = 100)
	private String address;

	@Column(length = 20)
	private String phoneNumber;

	@Column(length = 50)
	private String email;

	@Column
	private String profileImageUrl;

	@Column
	private int point;

	@Column
	private int missionCount;

	@NotNull
	@Column(columnDefinition = "VARCHAR(10)")
	@Enumerated(EnumType.STRING)
	private SocialStatus socialStatus;

	private String refreshToken;

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private List<UserAgree> memberAgreeList = new ArrayList<>();

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private List<UserPrefer> memberPreferList = new ArrayList<>();

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private List<UserMission> memberMissionList = new ArrayList<>();

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private List<Notification> notificationList = new ArrayList<>();

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private List<Point> pointList = new ArrayList<>();

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private List<Review> reviewList = new ArrayList<>();

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private List<Reply> replyList = new ArrayList<>();

	@Builder
	private User(String customId, String password, String userName,
		BirthDay birth, String address){
		this.customId = customId;
		this.password = password;
		this.userName = userName;
		this.userType = userType;
		this.userStatus = UserStatus.ACTIVE;
		this.gender = gender;
		this.birth = birth;
		this.address = address;
		this.socialStatus = socialStatus;
	}
}
