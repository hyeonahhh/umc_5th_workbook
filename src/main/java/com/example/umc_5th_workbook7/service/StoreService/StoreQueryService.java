package com.example.umc_5th_workbook7.service.StoreService;

import com.example.umc_5th_workbook7.domain.Mission;
import com.example.umc_5th_workbook7.domain.Store;

import java.util.Optional;

public interface StoreQueryService {

    Optional<Store> findStore(Long id);
    Optional<Mission> findMission(Long id);
}
