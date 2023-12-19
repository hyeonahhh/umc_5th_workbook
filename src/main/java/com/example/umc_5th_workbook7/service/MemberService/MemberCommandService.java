package com.example.umc_5th_workbook7.service.MemberService;

import com.example.umc_5th_workbook7.domain.Member;
import com.example.umc_5th_workbook7.domain.mapping.MemberMission;
import com.example.umc_5th_workbook7.web.dto.MemberRequestDTO;

public interface MemberCommandService {
    public Member joinMember(MemberRequestDTO.JoinDto request);
    public MemberMission createMemberMission(Long missionId, Long memberId);
}
