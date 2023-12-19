package com.example.umc_5th_workbook7.service.MemberService;

import com.example.umc_5th_workbook7.domain.Member;

import java.util.Optional;

public interface MemberQueryService {

    Optional<Member> findMember(Long id);

}