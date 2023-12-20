package com.example.umc_5th_workbook7.repository;

import com.example.umc_5th_workbook7.domain.FoodCategory;
import com.example.umc_5th_workbook7.domain.Member;
import com.example.umc_5th_workbook7.domain.Mission;
import com.example.umc_5th_workbook7.domain.mapping.MemberMission;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberMissionRepository extends JpaRepository<MemberMission, Long> {
    Optional<MemberMission> findMemberMissionByMemberAndMission(Member member, Mission mission);
}
