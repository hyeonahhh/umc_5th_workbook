package com.example.umc_5th_workbook7;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class Umc5thWorkbook7Application {

    public static void main(String[] args) {
        SpringApplication.run(Umc5thWorkbook7Application.class, args);
    }

}
