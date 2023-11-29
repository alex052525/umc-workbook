package umc.study.domain.member.entity;

import lombok.*;
import umc.study.domain.mapping.MemberFoodCategory;
import umc.study.domain.review.entity.Review;
import umc.study.global.entity.BaseTimeEntity;
import umc.study.domain.member.enums.Gender;
import umc.study.domain.member.enums.MemberStatus;
import umc.study.domain.mapping.MemberMission;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Member extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    private String email;

    @Column(nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "VARCHAR(15) DEFAULT 'ACTIVE'", nullable = false)
    private MemberStatus memberStatus;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Gender gender;

    @Column(nullable = false)
    private Integer point;

    private String birthDay;

    @Column(nullable = false)
    private String address;

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<MemberFoodCategory> foodCategoryPreference = new ArrayList<>();

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<MemberMission> memberMissions = new ArrayList<>();

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<Review> reviews = new ArrayList<>();

}