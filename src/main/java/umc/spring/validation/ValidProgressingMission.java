package umc.spring.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = ProgressingMissionValidator.class)
@Target({ElementType.TYPE, ElementType.PARAMETER}) // 클래스 레벨에서 검증
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidProgressingMission {
    String message() default "이미 도전 중인 미션입니다.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
