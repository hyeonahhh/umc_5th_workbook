package com.example.umc_5th_workbook7.apiPayload.validation.validator;

import com.example.umc_5th_workbook7.apiPayload.code.status.ErrorStatus;
import com.example.umc_5th_workbook7.apiPayload.validation.annotation.CheckPage;
import com.example.umc_5th_workbook7.apiPayload.validation.annotation.ExistStore;
import com.example.umc_5th_workbook7.domain.Store;
import com.example.umc_5th_workbook7.service.StoreService.StoreQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class CheckPageValidator implements ConstraintValidator<CheckPage, Integer> {

    private final StoreQueryService storeQueryService;

    @Override
    public void initialize(CheckPage constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {

        if (value < 0){
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.STORE_NOT_FOUND.toString()).addConstraintViolation();
            return false;
        }
        return true;
    }
}