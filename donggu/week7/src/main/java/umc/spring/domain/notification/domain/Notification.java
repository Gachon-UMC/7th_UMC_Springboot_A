package umc.spring.domain.notification.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import umc.spring.domain.shared.BaseTimeEntity;
import umc.spring.domain.user.domain.User;

@Entity
@Getter
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public abstract class Notification extends BaseTimeEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long notificationId;

	@NotNull
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private User user;

	@NotNull
	@Column
	private boolean confirmStatus;

	@NotNull
	@Column(length = 20)
	private String title;

	@NotNull
	@Column
	private String content;

	protected Notification(User user, boolean confirmStatus, String title, String content){
		this.user = user;
		this.title = title;
		this.content = content;
		this.confirmStatus = confirmStatus;
	}
}
