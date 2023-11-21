package com.example.umc_5th_workbook7.domain;

import com.example.umc_5th_workbook7.domain.common.BaseEntity;
import com.example.umc_5th_workbook7.domain.mapping.MemberPrefer;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class FoodCategory extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 15)
    private String name;

    @OneToMany(mappedBy = "foodCategory")
    private List<MemberPrefer> memberPrefers = new ArrayList<>();
}
