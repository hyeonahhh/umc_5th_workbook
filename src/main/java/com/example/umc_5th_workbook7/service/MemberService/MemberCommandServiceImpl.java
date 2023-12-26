package com.example.umc_5th_workbook7.service.MemberService;

import com.example.umc_5th_workbook7.apiPayload.code.status.ErrorStatus;
import com.example.umc_5th_workbook7.apiPayload.exception.handler.FoodCategoryHandler;
import com.example.umc_5th_workbook7.converter.MemberConverter;
import com.example.umc_5th_workbook7.converter.MemberPreferConverter;
import com.example.umc_5th_workbook7.domain.FoodCategory;
import com.example.umc_5th_workbook7.domain.Member;
import com.example.umc_5th_workbook7.domain.enums.MissionStatus;
import com.example.umc_5th_workbook7.domain.mapping.MemberMission;
import com.example.umc_5th_workbook7.domain.mapping.MemberPrefer;
import com.example.umc_5th_workbook7.repository.FoodCategoryRepository;
import com.example.umc_5th_workbook7.repository.MemberMissionRepository;
import com.example.umc_5th_workbook7.repository.MemberRepository;
import com.example.umc_5th_workbook7.repository.MissionRepository;
import com.example.umc_5th_workbook7.web.dto.MemberRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = false)
public class MemberCommandServiceImpl implements MemberCommandService{

    private final MemberRepository memberRepository;

    private final FoodCategoryRepository foodCategoryRepository;
    private final MissionRepository missionRepository;
    private final MemberMissionRepository memberMissionRepository;

    @Override
    @Transactional
    public Member joinMember(MemberRequestDTO.JoinDto request) {

        Member newMember = MemberConverter.toMember(request);
        List<FoodCategory> foodCategoryList = request.getPreferCategory().stream()
                .map(category -> {
                    return foodCategoryRepository.findById(category).orElseThrow(() -> new FoodCategoryHandler(ErrorStatus.FOOD_CATEGORY_NOT_FOUND));
                }).collect(Collectors.toList());

        List<MemberPrefer> memberPreferList = MemberPreferConverter.toMemberPreferList(foodCategoryList);

        memberPreferList.forEach(memberPrefer -> {memberPrefer.setMember(newMember);});

        return memberRepository.save(newMember);
    }

    @Override
    public MemberMission createMemberMission(Long missionId, Long memberId) {
        MemberMission memberMission = MemberMission.builder()
                .status(MissionStatus.CHALLENGING)
                .build();
        memberMission.setMember(memberRepository.findById(memberId).get());
        memberMission.setMission(missionRepository.findById(missionId).get());
        return memberMissionRepository.save(memberMission);


    }
}
