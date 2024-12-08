package umc.spring.domain.etc.notification.domain;

import lombok.Builder;
import umc.spring.domain.user.domain.User;

public class QuestionNotification extends Notification {
	@Builder
	private QuestionNotification(User user, String title, String content){
		super(user, title, content);
	}
}
