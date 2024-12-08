package umc.spring.domain.etc.notification.domain;

import lombok.Builder;
import umc.spring.domain.user.domain.User;

public class MissionNotification extends Notification {

	@Builder
	private MissionNotification(User user, String title, String content){
		super(user, title, content);
	}

	public static MissionNotification createMission(User user, String title, String content){
		return MissionNotification.builder()
			.user(user)
			.title(title)
			.content(content)
			.build();
	}
}
