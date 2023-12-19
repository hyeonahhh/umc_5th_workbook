package com.example.umc_5th_workbook7.service.StoreService;

import com.example.umc_5th_workbook7.domain.Mission;
import com.example.umc_5th_workbook7.domain.Review;
import com.example.umc_5th_workbook7.web.dto.StoreRequestDTO;

public interface StoreCommandService {
    Review createReview(Long memberId, Long storeId, StoreRequestDTO.ReveiwDTO request);
    Mission createMission(Long storeId, StoreRequestDTO.MissionDTO request);
}

