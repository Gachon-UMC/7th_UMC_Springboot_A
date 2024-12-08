package umc.spring.global.api.exception.handler;

import umc.spring.global.api.code.BaseErrorCode;
import umc.spring.global.api.exception.GeneralException;

public class StoreHandler extends GeneralException {
	public StoreHandler(BaseErrorCode errorCode) {
		super(errorCode);
	}
}
