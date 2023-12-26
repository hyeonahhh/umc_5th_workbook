package com.example.umc_5th_workbook7.apiPayload.exception.handler;

import com.example.umc_5th_workbook7.apiPayload.code.BaseErrorCode;
import com.example.umc_5th_workbook7.apiPayload.exception.GeneralException;

public class FoodCategoryHandler extends GeneralException {
    public FoodCategoryHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}
