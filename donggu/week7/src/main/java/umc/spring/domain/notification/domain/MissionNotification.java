package umc.spring.domain.notification.domain;

import lombok.Builder;
import umc.spring.domain.user.domain.User;

public class MissionNotification extends Notification {

	@Builder
	private MissionNotification(User user, boolean confirmStatus, String title, String content){
		super(user, confirmStatus, title, content);
	}
}
