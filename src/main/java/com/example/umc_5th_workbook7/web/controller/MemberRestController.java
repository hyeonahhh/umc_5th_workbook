package com.example.umc_5th_workbook7.web.controller;

import com.example.umc_5th_workbook7.apiPayload.ApiResponse;
import com.example.umc_5th_workbook7.apiPayload.validation.annotation.ExistMember;
import com.example.umc_5th_workbook7.apiPayload.validation.annotation.ExistMission;
import com.example.umc_5th_workbook7.apiPayload.validation.annotation.ExistStore;
import com.example.umc_5th_workbook7.converter.MemberConverter;
import com.example.umc_5th_workbook7.converter.MemberMissionConverter;
import com.example.umc_5th_workbook7.converter.StoreConverter;
import com.example.umc_5th_workbook7.domain.Member;
import com.example.umc_5th_workbook7.domain.Review;
import com.example.umc_5th_workbook7.domain.mapping.MemberMission;
import com.example.umc_5th_workbook7.service.MemberService.MemberCommandService;
import com.example.umc_5th_workbook7.web.dto.MemberRequestDTO;
import com.example.umc_5th_workbook7.web.dto.MemberResponseDTO;
import com.example.umc_5th_workbook7.web.dto.StoreRequestDTO;
import com.example.umc_5th_workbook7.web.dto.StoreResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberRestController {

    private final MemberCommandService memberCommandService;

    @PostMapping("/")
    public ApiResponse<MemberResponseDTO.JoinResultDTO> join(@RequestBody @Valid MemberRequestDTO.JoinDto request){
        Member member = memberCommandService.joinMember(request);
        return ApiResponse.onSuccess(MemberConverter.toJoinResultDTO(member));
    }

    @PostMapping("/{missionId}/missions")
    public ApiResponse<MemberResponseDTO.MemberMissionResultDTO> participateMission(
                                                                            @ExistMission @PathVariable(name = "missionId") Long missionId,
                                                                            @ExistMember @RequestParam(name = "memberId") Long memberId){
        MemberMission memberMission = memberCommandService.createMemberMission(missionId, memberId);
        return ApiResponse.onSuccess(MemberMissionConverter.toCreateMemberMissionResultDTO(memberMission));
    }
}