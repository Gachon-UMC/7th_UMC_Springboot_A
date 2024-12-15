package umc.spring.Vaildator.annotation;


import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import umc.spring.Vaildator.vaildator.StoreStatusExistValidator;
import umc.spring.Vaildator.vaildator.UserIdExistValidator;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = UserIdExistValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
public @interface ExistUserId {

    String message() default "유효하지 않은 상태 값입니다.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
