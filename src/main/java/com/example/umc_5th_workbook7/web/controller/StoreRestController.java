package com.example.umc_5th_workbook7.web.controller;

import com.example.umc_5th_workbook7.apiPayload.ApiResponse;
import com.example.umc_5th_workbook7.apiPayload.validation.annotation.ExistMember;
import com.example.umc_5th_workbook7.apiPayload.validation.annotation.ExistStore;
import com.example.umc_5th_workbook7.converter.StoreConverter;
import com.example.umc_5th_workbook7.domain.Mission;
import com.example.umc_5th_workbook7.domain.Review;
import com.example.umc_5th_workbook7.service.StoreService.StoreCommandService;
import com.example.umc_5th_workbook7.web.dto.StoreRequestDTO;
import com.example.umc_5th_workbook7.web.dto.StoreResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@Validated
@RequiredArgsConstructor
@RequestMapping("/stores")
public class StoreRestController {

    private final StoreCommandService storeCommandService;

    @PostMapping("/{storeId}/reviews")
    public ApiResponse<StoreResponseDTO.CreateReviewResultDTO> createReview(@RequestBody @Valid StoreRequestDTO.ReveiwDTO request,
                                                                            @ExistStore @PathVariable(name = "storeId") Long storeId,
                                                                            @ExistMember @RequestParam(name = "memberId") Long memberId){
        Review review = storeCommandService.createReview(memberId, storeId, request);
        return ApiResponse.onSuccess(StoreConverter.toCreateReviewResultDTO(review));
    }

    @PostMapping("/{storeId}/missions")
    public ApiResponse<StoreResponseDTO.CreateMissionResultDTO> createReview(@RequestBody @Valid StoreRequestDTO.MissionDTO request,
                                                                            @ExistStore @PathVariable(name = "storeId") Long storeId){
        Mission mission = storeCommandService.createMission(storeId, request);
        return ApiResponse.onSuccess(StoreConverter.toCreateMissionResultDTO(mission));
    }
}