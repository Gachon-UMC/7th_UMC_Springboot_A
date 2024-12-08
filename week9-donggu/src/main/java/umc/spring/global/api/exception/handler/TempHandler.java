package umc.spring.global.api.exception.handler;

import umc.spring.global.api.code.BaseErrorCode;
import umc.spring.global.api.exception.GeneralException;

public class TempHandler extends GeneralException {

	public TempHandler(BaseErrorCode errorCode) {
		super(errorCode);
	}
}
