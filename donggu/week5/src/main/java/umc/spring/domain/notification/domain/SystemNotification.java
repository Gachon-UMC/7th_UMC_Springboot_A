package umc.spring.domain.notification.domain;

import lombok.Builder;
import umc.spring.domain.user.domain.User;

public class SystemNotification extends Notification {
	@Builder
	private SystemNotification(User user, boolean confirmStatus, String title, String content){
		super(user, confirmStatus, title, content);
	}
}
