package com.example.umc_5th_workbook7.repository;

import com.example.umc_5th_workbook7.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
