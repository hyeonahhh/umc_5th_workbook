package com.example.umc_5th_workbook7.apiPayload.validation.validator;

import com.example.umc_5th_workbook7.apiPayload.code.status.ErrorStatus;
import com.example.umc_5th_workbook7.apiPayload.validation.annotation.ExistMission;
import com.example.umc_5th_workbook7.apiPayload.validation.annotation.IsChallenging;
import com.example.umc_5th_workbook7.domain.Mission;
import com.example.umc_5th_workbook7.domain.enums.MissionStatus;
import com.example.umc_5th_workbook7.domain.mapping.MemberMission;
import com.example.umc_5th_workbook7.service.MemberService.MemberQueryService;
import com.example.umc_5th_workbook7.service.StoreService.StoreQueryService;
import com.example.umc_5th_workbook7.web.dto.MemberMIssionRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class MissionIsChallengingValidator implements ConstraintValidator<IsChallenging, MemberMIssionRequestDTO.IsChallengingDTO> {

    private final MemberQueryService memberQueryService;



    @Override
    public void initialize(IsChallenging constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }


    @Override
    public boolean isValid(MemberMIssionRequestDTO.IsChallengingDTO value, ConstraintValidatorContext context) {
        System.out.println("validator");

        Optional<MemberMission> target = memberQueryService.findMemberMissionByMemberAndMission(value.getMemberId(), value.getMissionId());
        System.out.println(target.get());
        if (target.isPresent() && target.get().getStatus() == MissionStatus.CHALLENGING){
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.MISSION_NOT_FOUND.toString()).addConstraintViolation();
            return false;
        }
        return true;
    }
}