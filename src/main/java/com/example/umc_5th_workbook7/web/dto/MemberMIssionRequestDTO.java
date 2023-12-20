package com.example.umc_5th_workbook7.web.dto;

import com.example.umc_5th_workbook7.apiPayload.validation.annotation.ExistCategories;
import com.example.umc_5th_workbook7.apiPayload.validation.annotation.ExistMember;
import com.example.umc_5th_workbook7.apiPayload.validation.annotation.ExistMission;
import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

public class MemberMIssionRequestDTO {
    @Getter
    public static class IsChallengingDTO{

        @ExistMember
        Long memberId;

        @ExistMission
        Long missionId;
    }
}
