package com.example.umc_5th_workbook7.service.MemberService;

import com.example.umc_5th_workbook7.apiPayload.code.status.ErrorStatus;
import com.example.umc_5th_workbook7.apiPayload.exception.handler.TempHandler;
import com.example.umc_5th_workbook7.domain.Member;
import com.example.umc_5th_workbook7.domain.Mission;
import com.example.umc_5th_workbook7.domain.mapping.MemberMission;
import com.example.umc_5th_workbook7.repository.MemberMissionRepository;
import com.example.umc_5th_workbook7.repository.MemberRepository;
import com.example.umc_5th_workbook7.repository.MissionRepository;
import com.example.umc_5th_workbook7.repository.StoreRepository;
import com.example.umc_5th_workbook7.service.TempService.TempQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberQueryServiceImpl implements MemberQueryService{

    private final MemberRepository memberRepository;
    private final MemberMissionRepository memberMissionRepository;
    private final MissionRepository missionRepository;

    @Override
    public Optional<Member> findMember(Long id) {
        return memberRepository.findById(id);
    }

    @Override
    public Optional<MemberMission> findMemberMissionByMemberAndMission(Long memberId, Long missionId) {
        Optional<Member> member = findMember(memberId);
        Optional<Mission> mission = missionRepository.findById(missionId);

        return memberMissionRepository.findMemberMissionByMemberAndMission(member.get(), mission.get());
    }
}