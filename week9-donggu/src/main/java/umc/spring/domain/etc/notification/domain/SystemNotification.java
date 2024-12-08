package umc.spring.domain.etc.notification.domain;

import lombok.Builder;
import umc.spring.domain.user.domain.User;

public class SystemNotification extends Notification {
	@Builder
	private SystemNotification(User user, String title, String content){
		super(user, title, content);
	}
}
