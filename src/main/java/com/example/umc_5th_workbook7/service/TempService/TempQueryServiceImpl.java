package com.example.umc_5th_workbook7.service.TempService;

import com.example.umc_5th_workbook7.apiPayload.code.status.ErrorStatus;
import com.example.umc_5th_workbook7.apiPayload.exception.handler.TempHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TempQueryServiceImpl implements TempQueryService{

    @Override
    public void CheckFlag(Integer flag) {
        if (flag == 1)
            throw new TempHandler(ErrorStatus.TEMP_EXCEPTION);
    }
}