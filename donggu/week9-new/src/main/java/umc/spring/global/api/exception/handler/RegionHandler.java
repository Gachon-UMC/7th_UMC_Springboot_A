package umc.spring.global.api.exception.handler;

import umc.spring.global.api.code.BaseErrorCode;
import umc.spring.global.api.exception.GeneralException;

public class RegionHandler extends GeneralException {
	public RegionHandler(BaseErrorCode errorCode) {
		super(errorCode);
	}
}
