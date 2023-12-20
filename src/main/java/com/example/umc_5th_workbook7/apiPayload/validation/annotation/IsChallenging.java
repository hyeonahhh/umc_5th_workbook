package com.example.umc_5th_workbook7.apiPayload.validation.annotation;

import com.example.umc_5th_workbook7.apiPayload.validation.validator.MissionExistValidator;
import com.example.umc_5th_workbook7.apiPayload.validation.validator.MissionIsChallengingValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = MissionIsChallengingValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
public @interface IsChallenging {
    String message() default "해당 미션에 이미 도전중입니다.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}