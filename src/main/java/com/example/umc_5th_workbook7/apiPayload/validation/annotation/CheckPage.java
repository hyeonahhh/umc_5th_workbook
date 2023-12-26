package com.example.umc_5th_workbook7.apiPayload.validation.annotation;

import com.example.umc_5th_workbook7.apiPayload.validation.validator.CheckPageValidator;
import com.example.umc_5th_workbook7.apiPayload.validation.validator.MissionIsChallengingValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = CheckPageValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER, ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface CheckPage {
    String message() default "페이지 정보를 찾을 수 없습니다.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}