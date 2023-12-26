package com.example.umc_5th_workbook7.converter;

import com.example.umc_5th_workbook7.domain.enums.Gender;
import com.example.umc_5th_workbook7.web.dto.MemberRequestDTO;
import com.example.umc_5th_workbook7.web.dto.MemberResponseDTO;
import com.example.umc_5th_workbook7.web.dto.TempResponse;
import com.example.umc_5th_workbook7.domain.Member;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class MemberConverter {

    public static MemberResponseDTO.JoinResultDTO toJoinResultDTO(Member member){
        return MemberResponseDTO.JoinResultDTO.builder()
                .memberId(member.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }
    public static Member toMember(MemberRequestDTO.JoinDto request){

        Gender gender = null;

        switch (request.getGender()){
            case 1:
                gender = Gender.MALE;
                break;
            case 2:
                gender = Gender.FEMALE;
                break;
            case 3:
                gender = Gender.NONE;
                break;
        }

        return Member.builder()
                .address(request.getAddress())
                .specAddress(request.getSpecAddress())
                .gender(gender)
                .name(request.getName())
                .memberPreferList(new ArrayList<>())
                .build();
    }
}