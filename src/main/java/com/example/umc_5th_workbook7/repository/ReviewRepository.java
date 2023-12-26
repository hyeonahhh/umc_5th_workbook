package com.example.umc_5th_workbook7.repository;

import com.example.umc_5th_workbook7.domain.Member;
import com.example.umc_5th_workbook7.domain.Review;
import com.example.umc_5th_workbook7.domain.Store;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    Page<Review> findAllByStore(Store store, PageRequest pageRequest);
    Page<Review> findAllByMember(Member member, PageRequest pageRequest);
}
