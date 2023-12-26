package com.example.umc_5th_workbook7.service.MemberService;

import com.example.umc_5th_workbook7.domain.Member;
import com.example.umc_5th_workbook7.domain.Mission;
import com.example.umc_5th_workbook7.domain.mapping.MemberMission;

import java.util.Optional;

public interface MemberQueryService {

    Optional<Member> findMember(Long id);
    Optional<MemberMission> findMemberMissionByMemberAndMission(Long memberId, Long missionId);

}