package com.example.umc_5th_workbook7.repository;

import com.example.umc_5th_workbook7.domain.Review;
import com.example.umc_5th_workbook7.domain.Store;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoreRepository extends JpaRepository<Store, Long> {
}
