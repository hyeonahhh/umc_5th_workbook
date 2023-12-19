package com.example.umc_5th_workbook7.service.MemberService;

import com.example.umc_5th_workbook7.apiPayload.code.status.ErrorStatus;
import com.example.umc_5th_workbook7.apiPayload.exception.handler.TempHandler;
import com.example.umc_5th_workbook7.domain.Member;
import com.example.umc_5th_workbook7.repository.MemberRepository;
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

    @Override
    public Optional<Member> findMember(Long id) {
        return memberRepository.findById(id);
    }
}