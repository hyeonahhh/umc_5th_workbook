package com.example.umc_5th_workbook7.converter;

import com.example.umc_5th_workbook7.domain.FoodCategory;
import com.example.umc_5th_workbook7.domain.Member;
import com.example.umc_5th_workbook7.domain.mapping.MemberMission;
import com.example.umc_5th_workbook7.domain.mapping.MemberPrefer;
import com.example.umc_5th_workbook7.web.dto.MemberResponseDTO;
import com.example.umc_5th_workbook7.web.dto.StoreResponseDTO;
import org.springframework.data.domain.Page;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class MemberMissionConverter {

    public static MemberResponseDTO.MemberMissionResultDTO toCreateMemberMissionResultDTO(MemberMission memberMission){
        return MemberResponseDTO.MemberMissionResultDTO.builder()
                .memberMissionId(memberMission.getId())
                .build();
    }

    public static StoreResponseDTO.MissionPreViewDTO toMissionPreViewDTO(MemberMission memberMission) {
        return StoreResponseDTO.MissionPreViewDTO.builder()
                .reward(memberMission.getMission().getReward())
                .deadline(memberMission.getMission().getDeadline())
                .missionSpec(memberMission.getMission().getMissionSpec())
                .build();
    }

    public static StoreResponseDTO.MissionPreViewListDTO toMissionPreViewListDTO(Page<MemberMission> memberMissionList) {
        List<StoreResponseDTO.MissionPreViewDTO> missionPreViewDTOList = memberMissionList.stream()
                .map(MemberMissionConverter::toMissionPreViewDTO).collect(Collectors.toList());
        return StoreResponseDTO.MissionPreViewListDTO.builder()
                .isLast(memberMissionList.isLast())
                .isFirst(memberMissionList.isFirst())
                .totalPage(memberMissionList.getTotalPages())
                .totalElements(memberMissionList.getTotalElements())
                .listSize(missionPreViewDTOList.size())
                .missionList(missionPreViewDTOList)
                .build();
    }
}