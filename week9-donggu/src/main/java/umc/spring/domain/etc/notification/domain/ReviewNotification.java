package umc.spring.domain.etc.notification.domain;

import lombok.Builder;
import umc.spring.domain.user.domain.User;

public class ReviewNotification extends Notification {
	@Builder
	private ReviewNotification(User user, String title, String content){
		super(user, title, content);
	}
}
