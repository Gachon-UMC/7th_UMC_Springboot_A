package umc.spring.global.api.exception.handler;

import umc.spring.global.api.code.BaseErrorCode;
import umc.spring.global.api.exception.GeneralException;

public class MissionHandler extends GeneralException {
	public MissionHandler(BaseErrorCode errorCode) {
		super(errorCode);
	}
}
