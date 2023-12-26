package com.example.umc_5th_workbook7.repository;

import com.example.umc_5th_workbook7.domain.Mission;
import com.example.umc_5th_workbook7.domain.Store;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MissionRepository extends JpaRepository<Mission, Long> {
}
