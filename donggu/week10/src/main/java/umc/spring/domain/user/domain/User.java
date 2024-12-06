package umc.spring.domain.user.domain;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

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
import umc.spring.domain.etc.notification.domain.Notification;
import umc.spring.domain.point.domain.Point;
import umc.spring.domain.reply.domain.Reply;
import umc.spring.domain.review.domain.Review;
import umc.spring.domain.shared.BaseTimeEntity;
import umc.spring.domain.shared.Gender;
import umc.spring.domain.shared.Role;
import umc.spring.domain.shared.SocialStatus;
import umc.spring.domain.shared.UserStatus;

@Entity(name = "users")
@Getter
@DynamicUpdate
@DynamicInsert
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User extends BaseTimeEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userId;

	@NotNull
	@Column
	private String userName;

	@NotNull
	@Column
	private String password;

	@NotNull
	@Column(columnDefinition = "VARCHAR(20)")
	@Enumerated(EnumType.STRING)
	private Role role;

	@Column(length = 20)
	private String nickname;

	@NotNull
	@Column(columnDefinition = "VARCHAR(30) DEFAULT 'ACTIVE'")
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

	@Column(length = 100)
	private String extraAddress;

	@Column(length = 20)
	private String phoneNumber;

	@NotNull
	@Column(length = 50, unique = true)
	private String email;

	@Column
	private String profileImageUrl;

	@Column
	private int point;

	@Column(columnDefinition = "VARCHAR(10)")
	@Enumerated(EnumType.STRING)
	private SocialStatus socialStatus;

	private String refreshToken;

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private List<UserAgree> userAgreeList = new ArrayList<>();

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private List<UserPrefer> userPreferList = new ArrayList<>();

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private List<UserMission> userMissionList = new ArrayList<>();

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private List<Notification> notificationList = new ArrayList<>();

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private List<Point> pointList = new ArrayList<>();

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private List<Review> reviewList = new ArrayList<>();

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private List<Reply> replyList = new ArrayList<>();

	@Builder
	private User(String userName, String email, String password, Gender gender, BirthDay birth, String address,
		String extraAddress, Role role) {
		this.userName = userName;
		this.gender = gender;
		this.birth = birth;
		this.address = address;
		this.extraAddress = extraAddress;
		this.userStatus = UserStatus.ACTIVE;
		this.role = role;
		this.email = email;
		this.password = password;
	}

	public static User create(String userName, Gender gender, int birthD, int birthM, int birthY,
		String address, String extraAddress, Role role, String email, String password) {
		return User.builder()
			.userName(userName)
			.gender(gender)
			.birth(BirthDay.builder().day(birthD).year(birthM).month(birthY).build())
			.address(address)
			.extraAddress(extraAddress)
			.role(role)
			.email(email)
			.password(password)
			.build();
	}

	public void encodePassword(String password){
		this.password = password;
	}

	public void addPrefer(List<UserPrefer> preferList) {
		if(this.userPreferList == null) {
			this.userPreferList = new ArrayList<>();
		}
		this.userPreferList.addAll(preferList);
	}
}

//유저 삽입용
/*INSERT INTO users
(user_name, gender, year, month, day, address, extra_address, user_status, inactive_date, nickname, phone_number, email, profile_image_url, point, refresh_token)
VALUES
    ('John Doe', 'MALE', 1990, 1, 15, '123 Main St', 'Apt 456', 'ACTIVE', NULL, 'Johnny', '123-456-7890', 'john.doe@example.com', 'http://example.com/profile.jpg', 100, 'abcd1234refresh');
UPDATE users SET created_at = '2023-11-28 12:00:00' WHERE user_name = 'John Doe';
    */

