package com.example.umc_5th_workbook7.web.dto;

import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class StoreRequestDTO {
    @Getter
    public static class ReveiwDTO{
            @NotBlank
            String title;
            @NotNull
            Float score;
            @NotBlank
            String body;

    }

    @Getter
    public static class MissionDTO {
        Integer reward;
        @NotBlank
        String missionSpec;



    }
}
