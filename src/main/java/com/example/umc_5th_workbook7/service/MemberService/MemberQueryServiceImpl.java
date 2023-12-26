package com.example.umc_5th_workbook7.service.MemberService;

import com.example.umc_5th_workbook7.apiPayload.code.status.ErrorStatus;
import com.example.umc_5th_workbook7.apiPayload.exception.handler.TempHandler;
import com.example.umc_5th_workbook7.domain.Member;
import com.example.umc_5th_workbook7.domain.Mission;
import com.example.umc_5th_workbook7.domain.Review;
import com.example.umc_5th_workbook7.domain.enums.MissionStatus;
import com.example.umc_5th_workbook7.domain.mapping.MemberMission;
import com.example.umc_5th_workbook7.repository.*;
import com.example.umc_5th_workbook7.service.TempService.TempQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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
    private final ReviewRepository reviewRepository;

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

    @Override
    public Page<Review> getMyReviewList(Long memberId, Integer page) {
        Member member = findMember(memberId).get();
        Page<Review> StorePage = reviewRepository.findAllByMember(member, PageRequest.of(page, 10));
        return StorePage;
    }

    @Override
    public Page<MemberMission> getMyChallengingList(Long memberId, Integer page) {
        Member member = findMember(memberId).get();
        Page<MemberMission> StorePage = memberMissionRepository.findAllByMemberAndStatus(member, MissionStatus.CHALLENGING, PageRequest.of(page, 10));
        return StorePage;
    }
}