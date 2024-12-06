package umc.spring.global.api.exception.handler;

import umc.spring.global.api.code.BaseErrorCode;
import umc.spring.global.api.exception.GeneralException;

public class FoodCategoryHandler extends GeneralException {
  public FoodCategoryHandler(BaseErrorCode errorCode) {
    super(errorCode);
  }
}
