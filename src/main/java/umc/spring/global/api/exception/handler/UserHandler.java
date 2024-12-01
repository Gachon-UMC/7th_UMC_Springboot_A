package umc.spring.global.api.exception.handler;

import umc.spring.global.api.code.status.ErrorStatus;
import umc.spring.global.api.exception.GeneralException;

public class UserHandler extends GeneralException {
	public UserHandler(ErrorStatus errorStatus) {
		super(errorStatus);
	}
}
