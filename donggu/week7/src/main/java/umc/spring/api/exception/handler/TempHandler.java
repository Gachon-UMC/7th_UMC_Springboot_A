package umc.spring.api.exception.handler;

import umc.spring.api.code.BaseErrorCode;
import umc.spring.api.exception.GeneralException;

public class TempHandler extends GeneralException {

	public TempHandler(BaseErrorCode errorCode) {
		super(errorCode);
	}
}
